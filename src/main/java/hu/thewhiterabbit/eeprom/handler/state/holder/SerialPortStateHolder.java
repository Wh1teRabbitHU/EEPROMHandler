package hu.thewhiterabbit.eeprom.handler.state.holder;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.fazecast.jSerialComm.SerialPort;

import hu.thewhiterabbit.eeprom.handler.state.event.SerialPortChangeEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Component
@RequiredArgsConstructor
public class SerialPortStateHolder {

	private final ApplicationEventPublisher applicationEventPublisher;

	private SerialPort currentSerialPort;

	public void changeSerialPort(SerialPort serialPort) {
		this.currentSerialPort = serialPort;

		applicationEventPublisher.publishEvent(new SerialPortChangeEvent(this, serialPort));
	}

}
