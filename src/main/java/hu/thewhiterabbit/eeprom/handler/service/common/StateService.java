package hu.thewhiterabbit.eeprom.handler.service.common;

import org.springframework.stereotype.Service;

import com.fazecast.jSerialComm.SerialPort;

import hu.thewhiterabbit.eeprom.handler.state.holder.SerialPortStateHolder;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StateService {

	private final SerialPortStateHolder serialPortStateHolder;

	public void cleanUpOnClose() {
		SerialPort serialPort = serialPortStateHolder.getCurrentSerialPort();

		if (serialPort != null && serialPort.isOpen()) {
			serialPort.closePort();
		}
	}

}
