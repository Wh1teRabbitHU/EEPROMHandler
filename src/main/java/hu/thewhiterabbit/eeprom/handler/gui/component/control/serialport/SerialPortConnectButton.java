package hu.thewhiterabbit.eeprom.handler.gui.component.control.serialport;

import javax.annotation.PostConstruct;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.fazecast.jSerialComm.SerialPort;

import hu.thewhiterabbit.eeprom.handler.state.event.SerialPortChangeEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class SerialPortConnectButton extends Button {

	private static final String CONNECT_TEXT = "Connect";
	private static final String DISCONNECT_TEXT = "Disconnect";

	private SerialPort serialPort = null;

	@PostConstruct
	public void init() {
		updateStatus();

		addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
			if (serialPort == null) {
				throw new RuntimeException("The selected serial port must be not null!");
			}

			boolean success;

			if (serialPort.isOpen()) {
				success = serialPort.closePort();
			} else {
				success = serialPort.openPort();
			}

			if (success) {
				log.info("Successfully {}ed to the selected serial port", getText().toLowerCase());
			} else {
				log.warn("Couldn't {} to the selected serial port", getText().toLowerCase());
			}

			updateStatus();
		});
	}

	@EventListener
	public void handleSerialPortChange(SerialPortChangeEvent serialPortChangeEvent) {
		serialPort = serialPortChangeEvent.getSerialPort();

		updateStatus();
	}

	private void updateStatus() {
		if (serialPort == null) {
			setText(CONNECT_TEXT);
			setDisabled(true);

			return;
		}

		boolean isPortOpen = serialPort.isOpen();

		setText(isPortOpen ? DISCONNECT_TEXT : CONNECT_TEXT);
		setDisabled(false);
	}

}
