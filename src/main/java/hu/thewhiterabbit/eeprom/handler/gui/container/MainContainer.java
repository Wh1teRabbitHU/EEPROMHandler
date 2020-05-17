package hu.thewhiterabbit.eeprom.handler.gui.container;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import javafx.scene.layout.BorderPane;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MainContainer extends BorderPane {

	private final MainControlContainer mainControlContainer;
	private final DataContainer dataContainer;

	@PostConstruct
	public void init() {
		setTop(mainControlContainer);
		setCenter(dataContainer);
	}

}
