package hu.thewhiterabbit.eeprom.handler.gui.component.common;

import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.model.common.AlertWindowProperties;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AlertWindow {

	private Stage alertWindow;

	public void openWindow(AlertWindowProperties properties) {
		Platform.runLater(() -> {
			alertWindow = new Stage();
			alertWindow.initModality(Modality.APPLICATION_MODAL);
			VBox dialogVbox = new VBox(20);
			dialogVbox.getChildren()
					  .add(new Text("This is a Dialog"));
			Scene dialogScene = new Scene(dialogVbox, 300, 200);
			alertWindow.setScene(dialogScene);
			alertWindow.show();
		});
	}

}
