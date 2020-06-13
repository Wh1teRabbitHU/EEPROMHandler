package hu.thewhiterabbit.eeprom.handler.state.event;

import com.fazecast.jSerialComm.SerialPort;

public class SerialPortChangeEvent extends BaseChangeEvent<SerialPort> {

	public SerialPortChangeEvent(final Object source, final SerialPort changedData) {
		super(source, changedData);
	}

}
