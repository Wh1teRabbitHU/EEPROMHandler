package hu.thewhiterabbit.eeprom.handler.service.eeprom;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.fazecast.jSerialComm.SerialPort;

import hu.thewhiterabbit.eeprom.handler.model.eeprom.Block;
import hu.thewhiterabbit.eeprom.handler.service.common.SerialPortService;
import hu.thewhiterabbit.eeprom.handler.state.holder.DataStateHolder;
import hu.thewhiterabbit.eeprom.handler.state.holder.SerialPortStateHolder;
import hu.thewhiterabbit.eeprom.handler.util.MathUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EepromService {

	private static final int MAX_TRY = 100;
	private static final String ADDRESS_VALUE_SEPARATOR = "=";

	private final DataStateHolder dataStateHolder;
	private final SerialPortService serialPortService;
	private final SerialPortStateHolder serialPortStateHolder;

	public void readEeprom() {
		SerialPort serialPort = serialPortStateHolder.getCurrentSerialPort();

		clearSerialInput(serialPort);

		Set<Block> blocks = new HashSet<>();
		int failedRead = 0;

		for (int i = 0; i < dataStateHolder.getEepromType().maxAddress; i++) {
			Optional<Block> optionalBlock = readBlock(serialPort, i);

			if (optionalBlock.isEmpty()) {
				log.warn("Couldn't read the following address: {}", i);
				failedRead++;
			} else {
				blocks.add(optionalBlock.get());
			}
		}

		log.info("Successfully finished reading data from the EEPROM! " +
				 "Blocks: {}, failed reads: {}", blocks.size(), failedRead);

		dataStateHolder.changeBlocks(blocks);
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
		log.trace("Reading the following address: {}", address);

		String addressString = MathUtil.paddedBinary(address, 5);

		serialPortService.write(serialPort, "r" + addressString);

		String incomingData = null;

		int tries = 0;

		while (incomingData == null && tries < MAX_TRY) {
			incomingData = serialPortService.read(serialPort);

			if (incomingData == null) {
				tries++;

				try {
					Thread.sleep(1);
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
