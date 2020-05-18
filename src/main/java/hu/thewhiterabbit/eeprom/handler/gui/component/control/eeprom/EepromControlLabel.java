package hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import javafx.scene.control.Label;

@Component
public class EepromControlLabel extends Label {

	@PostConstruct
	public void init() {
		setText("EEPROM Data");
	}

}
