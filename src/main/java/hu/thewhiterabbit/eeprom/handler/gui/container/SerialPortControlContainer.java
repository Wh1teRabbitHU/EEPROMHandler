package hu.thewhiterabbit.eeprom.handler.gui.container;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.gui.component.control.serialport.SerialPortComboBox;
import hu.thewhiterabbit.eeprom.handler.gui.component.control.serialport.SerialPortSelectorLabel;
import hu.thewhiterabbit.eeprom.handler.util.GuiUtil;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SerialPortControlContainer extends HBox {

	private final SerialPortSelectorLabel serialPortSelectorLabel;
	private final SerialPortComboBox serialPortComboBox;

	@PostConstruct
	public void init() {
		getChildren().addAll(serialPortSelectorLabel, serialPortComboBox);

		setAlignment(Pos.CENTER_LEFT);
		setPadding(GuiUtil.CONTAINER_PADDING);

		for (Node children : getChildren()) {
			setMargin(children, GuiUtil.CONTAINER_CHILDREN_MARGIN);
		}
	}

}
