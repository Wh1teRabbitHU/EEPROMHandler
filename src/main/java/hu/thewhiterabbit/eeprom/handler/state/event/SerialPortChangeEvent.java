package hu.thewhiterabbit.eeprom.handler.state.event;

import org.springframework.context.ApplicationEvent;

import com.fazecast.jSerialComm.SerialPort;

import lombok.Getter;

@Getter
public class SerialPortChangeEvent extends ApplicationEvent {

	private final SerialPort serialPort;

	public SerialPortChangeEvent(final Object source, final SerialPort serialPort) {
		super(source);

		this.serialPort = serialPort;
	}

}
