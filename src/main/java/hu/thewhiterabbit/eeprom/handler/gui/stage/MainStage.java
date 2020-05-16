package hu.thewhiterabbit.eeprom.handler.gui.stage;

import org.springframework.stereotype.Component;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

@Component
public class MainStage extends Stage {

	public void init() {
		Label l = new Label("EEPROM Handler");
		Scene scene = new Scene(new StackPane(l), 640, 480);

		this.setScene(scene);
		this.setTitle("EEPROM Handler");
		this.show();
	}

}
