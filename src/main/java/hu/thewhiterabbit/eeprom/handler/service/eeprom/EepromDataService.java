package hu.thewhiterabbit.eeprom.handler.service.eeprom;

import static hu.thewhiterabbit.eeprom.handler.util.MathUtil.calculatePercentage;

import java.util.Optional;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.fazecast.jSerialComm.SerialPort;

import hu.thewhiterabbit.eeprom.handler.gui.component.common.AlertWindow;
import hu.thewhiterabbit.eeprom.handler.model.eeprom.Block;
import hu.thewhiterabbit.eeprom.handler.model.eeprom.Eeprom;
import hu.thewhiterabbit.eeprom.handler.state.holder.EepromStateHolder;
import hu.thewhiterabbit.eeprom.handler.state.holder.SerialPortStateHolder;
import hu.thewhiterabbit.eeprom.handler.state.holder.StatusBarStateHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class EepromDataService {

	private final EepromService eepromService;
	private final StatusBarStateHolder statusBarStateHolder;
	private final EepromStateHolder eepromStateHolder;
	private final SerialPortStateHolder serialPortStateHolder;

	private final AlertWindow alertWindow;

	@Async
	public void newEepromData() {
		Eeprom eeprom = new Eeprom(eepromStateHolder.getEepromType());

		alertWindow.openWindow(null);

		eepromStateHolder.changeEeprom(eeprom);
	}

	@Async
	public void readEepromData() {
		SerialPort serialPort = serialPortStateHolder.getCurrentSerialPort();

		eepromService.clearSerialInput(serialPort);

		Eeprom eeprom = new Eeprom(eepromStateHolder.getEepromType());
		int maxAddress = eeprom.getType().maxAddress;
		int successfullyRead = 0;
		int failedRead = 0;

		statusBarStateHolder.changePercentage(0);
		statusBarStateHolder.changeStatusText(String.format("%s / %s", 0, maxAddress));

		for (int i = 0; i < maxAddress; i++) {
			Optional<Block> optionalBlock = eepromService.readBlock(serialPort, i);

			if (optionalBlock.isEmpty()) {
				log.warn("Couldn't read the following address: {}", i);
				failedRead++;
			} else {
				eeprom.updateBlock(i, optionalBlock.get());
				successfullyRead++;
			}

			statusBarStateHolder.changePercentage(calculatePercentage(i, maxAddress));
			statusBarStateHolder.changeStatusText(String.format("%s / %s", i, maxAddress));
		}

		log.info("Successfully finished reading data from the EEPROM! " +
				 "Blocks: {}, failed reads: {}", successfullyRead, failedRead);

		statusBarStateHolder.changePercentage(100);
		statusBarStateHolder.changeStatusText(String.format("The reading process successfully finished! " +
															"Blocks: %s, failed reads: %s", successfullyRead,
															failedRead));

		eepromStateHolder.changeEeprom(eeprom);
	}

	@Async
	public void closeEepromData() {
		eepromStateHolder.changeEeprom(null);
	}

}
