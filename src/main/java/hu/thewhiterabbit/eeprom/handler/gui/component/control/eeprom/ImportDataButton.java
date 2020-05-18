package hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import javafx.scene.control.Button;

@Component
public class ImportDataButton extends Button {

	@PostConstruct
	public void init() {
		setText("Import");
	}

}
