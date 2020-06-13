package hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.service.eeprom.EepromDataService;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NewEepromDataButton extends Button {

	private final EepromDataService eepromDataService;

	@PostConstruct
	public void init() {
		setText("New");

		addEventHandler(MouseEvent.MOUSE_CLICKED, event -> eepromDataService.newEepromData());
	}

}
