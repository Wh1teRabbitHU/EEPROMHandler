package hu.thewhiterabbit.eeprom.handler.state.holder;

import org.springframework.stereotype.Component;

import com.fazecast.jSerialComm.SerialPort;

import hu.thewhiterabbit.eeprom.handler.state.event.SerialPortChangeEvent;
import lombok.Getter;

@Getter
@Component
public class SerialPortStateHolder extends BaseStateHolder {

	private SerialPort currentSerialPort;

	public void changeSerialPort(SerialPort serialPort) {
		this.currentSerialPort = serialPort;

		publishEvent(new SerialPortChangeEvent(this, serialPort));
	}

}
