package hu.thewhiterabbit.eeprom.handler.gui.container;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.service.eeprom.EepromService;
import hu.thewhiterabbit.eeprom.handler.util.GuiUtil;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EepromControlContainer extends HBox {

	private final EepromService eepromService;

	@PostConstruct
	public void init() {
		Label label = new Label("EEPROM Control panel");
		Button button = new Button("Fetch data");

		button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> eepromService.readEeprom());

		getChildren().addAll(label, button);

		setAlignment(Pos.CENTER_LEFT);
		setPadding(GuiUtil.CONTAINER_PADDING);

		for (Node children : getChildren()) {
			setMargin(children, GuiUtil.CONTAINER_CHILDREN_MARGIN);
		}
	}

}
