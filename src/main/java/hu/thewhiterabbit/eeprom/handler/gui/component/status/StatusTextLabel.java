package hu.thewhiterabbit.eeprom.handler.gui.component.status;

import javax.annotation.PostConstruct;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.state.event.StatusTextChangeEvent;
import javafx.application.Platform;
import javafx.scene.control.Label;

@Component
public class StatusTextLabel extends Label {

	@PostConstruct
	public void init() {
		setText("");
	}

	@EventListener
	public void handleStatusTextChange(StatusTextChangeEvent statusTextChangeEvent) {
		Platform.runLater(() -> setText(statusTextChangeEvent.getStatustext()));
	}

}
