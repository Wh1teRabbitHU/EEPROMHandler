package hu.thewhiterabbit.eeprom.handler.gui.container;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MainControlContainer extends VBox {

	private final SerialPortControlContainer serialPortControlContainer;
	private final EepromControlContainer eepromControlContainer;

	@PostConstruct
	public void init() {
		setAlignment(Pos.CENTER);

		getChildren().addAll(serialPortControlContainer, eepromControlContainer);
	}

}
