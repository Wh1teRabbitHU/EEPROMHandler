package hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import javafx.scene.control.Button;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class WriteEepromDataButton extends Button {

	@PostConstruct
	public void init() {
		setText("Write");
	}

}
