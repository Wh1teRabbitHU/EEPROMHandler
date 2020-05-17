package hu.thewhiterabbit.eeprom.handler.gui.stage;

import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.service.eeprom.EepromService;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class MainStage extends Stage {

	private final EepromService eepromService;

	public void init() {
		Label label = new Label("EEPROM Handler");
		Button button = new Button("Fetch data");
		Scene scene = new Scene(new FlowPane(label, button), 640, 480);

		button.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> eepromService.readEeprom());

		this.setScene(scene);
		this.setTitle("EEPROM Handler");
		this.show();
	}


}
