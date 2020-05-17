package hu.thewhiterabbit.eeprom.handler.gui.component.control.serialport;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import javafx.scene.control.Label;

@Component
public class SerialPortSelectorLabel extends Label {

	@PostConstruct
	public void init() {
		setText("Available serial ports:");
	}

}
