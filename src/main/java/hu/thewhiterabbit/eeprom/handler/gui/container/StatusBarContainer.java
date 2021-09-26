package hu.thewhiterabbit.eeprom.handler.gui.container;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.gui.component.common.PercentageBar;
import hu.thewhiterabbit.eeprom.handler.gui.component.common.StatusTextLabel;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class StatusBarContainer extends HBox {

	private final StatusTextLabel statusTextLabel;
	private final PercentageBar percentageBar;

	@PostConstruct
	public void init() {
		setAlignment(Pos.CENTER_RIGHT);

		getChildren().addAll(statusTextLabel, percentageBar);
	}

}
