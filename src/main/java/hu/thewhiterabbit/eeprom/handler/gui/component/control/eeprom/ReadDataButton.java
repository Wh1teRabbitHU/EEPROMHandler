package hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.service.eeprom.EepromService;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReadDataButton extends Button {

	private final EepromService eepromService;

	@PostConstruct
	public void init() {
		setText("Read from EEPROM");

		addEventHandler(MouseEvent.MOUSE_CLICKED, event -> eepromService.readEeprom());
	}

}
