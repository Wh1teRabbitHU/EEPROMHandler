package hu.thewhiterabbit.eeprom.handler.gui.container;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom.EepromControlLabel;
import hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom.ExportDataButton;
import hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom.ReadDataButton;
import hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom.ImportDataButton;
import hu.thewhiterabbit.eeprom.handler.util.GuiUtil;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EepromControlContainer extends HBox {

	private final EepromControlLabel eepromControlLabel;
	private final ReadDataButton readDataButton;
	private final ImportDataButton importDataButton;
	private final ExportDataButton exportDataButton;

	@PostConstruct
	public void init() {
		getChildren().addAll(eepromControlLabel, readDataButton, importDataButton, exportDataButton);

		setAlignment(Pos.CENTER_LEFT);
		setPadding(GuiUtil.CONTAINER_PADDING);

		for (Node children : getChildren()) {
			setMargin(children, GuiUtil.CONTAINER_CHILDREN_MARGIN);
		}
	}

}
