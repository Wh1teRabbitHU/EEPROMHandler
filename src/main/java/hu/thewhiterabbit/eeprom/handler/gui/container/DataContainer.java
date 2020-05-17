package hu.thewhiterabbit.eeprom.handler.gui.container;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.gui.component.data.DataTable;
import javafx.scene.control.ScrollPane;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataContainer extends ScrollPane {

	private final DataTable dataTable;

	@PostConstruct
	public void init() {
		setFitToWidth(true);
		setFitToHeight(true);
		setContent(dataTable);
	}

}
