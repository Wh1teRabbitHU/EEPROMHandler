package hu.thewhiterabbit.eeprom.handler.service.eeprom;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fazecast.jSerialComm.SerialPort;

import hu.thewhiterabbit.eeprom.handler.model.eeprom.Block;
import hu.thewhiterabbit.eeprom.handler.model.eeprom.Eeprom;
import hu.thewhiterabbit.eeprom.handler.service.common.SerialPortService;
import hu.thewhiterabbit.eeprom.handler.util.MathUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EepromService {

	private static final int MAX_TRY = 10;
	private static final String ADDRESS_VALUE_SEPARATOR = "=";

	private boolean initialised = false;
	private final List<SerialPort> serialPorts = new ArrayList<>();

	private final SerialPortService serialPortService;

	public void loadPorts() {
		for (SerialPort serialPort : serialPorts) {
			if (serialPort.isOpen()) {
				serialPort.closePort();
			}
		}

		serialPorts.clear();
		serialPorts.addAll(serialPortService.getAvailablePorts());
	}

	public Optional<SerialPort> getPort(String systemPortName) { // cu.usbmodem142101
		if (!initialised) {
			loadPorts();

			initialised = true;
		}

		return serialPorts.stream()
						  .filter(sp -> Objects.equals(sp.getSystemPortName(), systemPortName))
						  .findFirst();
	}

	public Eeprom readEeprom() {
		Eeprom eeprom = Eeprom.AT28C64();
		Optional<SerialPort> serialPortOptional = getPort("cu.usbmodem142101");

		if (serialPortOptional.isEmpty()) {
			log.warn("The selected port is not present!");

			return eeprom;
		}

		SerialPort serialPort = serialPortOptional.get();

		clearSerialInput(serialPort);

		for (int i = 0; i < eeprom.getType().maxAddress; i++) {
			Optional<Block> optionalBlock = readBlock(serialPort, i);

			if (optionalBlock.isEmpty()) {
				log.warn("Couldn't read the following address: {}", i);
			} else {
				eeprom.addBlock(optionalBlock.get());
			}
		}

		log.info("Successfully fetched eeprom: {}", eeprom);

		return eeprom;
	}

	public void clearSerialInput(SerialPort serialPort) {
		serialPortService.read(serialPort);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public Optional<Block> readBlock(SerialPort serialPort, int address) {
		log.debug("Reading the following address: {}", address);

		String addressString = MathUtil.paddedBinary(address, 5);

		serialPortService.write(serialPort, "r" + addressString);

		String incomingData = null;

		int tries = 0;

		while (incomingData == null && tries < MAX_TRY) {
			incomingData = serialPortService.read(serialPort);

			if (incomingData == null) {
				tries++;

				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		if (incomingData == null) {
			return Optional.empty();
		}

		String[] addressValue = incomingData.trim()
											.split(ADDRESS_VALUE_SEPARATOR);

		if (addressValue.length != 2) {
			return Optional.empty();
		}

		int value = Integer.parseInt(addressValue[1]);

		return Optional.of(new Block(address, value));
	}

}
