package hu.thewhiterabbit.eeprom.handler.gui.container;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom.CloseEepromDataButton;
import hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom.EepromControlLabel;
import hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom.EepromTypeComboBox;
import hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom.ExportEepromDataButton;
import hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom.ImportEepromDataButton;
import hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom.NewEepromDataButton;
import hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom.ReadEepromDataButton;
import hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom.WriteEepromDataButton;
import hu.thewhiterabbit.eeprom.handler.util.GuiUtil;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EepromControlContainer extends HBox {

	private final EepromControlLabel eepromControlLabel;
	private final EepromTypeComboBox eepromTypeComboBox;
	private final NewEepromDataButton newEepromDataButton;
	private final ReadEepromDataButton readEepromDataButton;
	private final WriteEepromDataButton writeEepromDataButton;
	private final ImportEepromDataButton importEepromDataButton;
	private final ExportEepromDataButton exportEepromDataButton;
	private final CloseEepromDataButton closeEepromDataButton;

	@PostConstruct
	public void init() {
		getChildren().addAll(eepromControlLabel, eepromTypeComboBox, newEepromDataButton, readEepromDataButton,
							 writeEepromDataButton, importEepromDataButton, exportEepromDataButton,
							 closeEepromDataButton);

		setAlignment(Pos.CENTER_LEFT);
		setPadding(GuiUtil.CONTAINER_PADDING);

		for (Node children : getChildren()) {
			setMargin(children, GuiUtil.CONTAINER_CHILDREN_MARGIN);
		}
	}

}
