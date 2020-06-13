package hu.thewhiterabbit.eeprom.handler.gui.component.status;

import javax.annotation.PostConstruct;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.state.event.PercentageChangeEvent;
import javafx.scene.control.ProgressBar;

@Component
public class PercentageBar extends ProgressBar {

	private boolean previousVisibility = true;

	@PostConstruct
	public void init() {
		setProgress(0);
		toggleBar(false);
	}

	@EventListener
	public void handlePercentageChange(PercentageChangeEvent percentageChangeEvent) {
		int percentage = percentageChangeEvent.getChangedData();

		setProgress(percentage / 100f);
		toggleBar(percentage != 100);
	}

	private void toggleBar(boolean visible) {
		if (this.previousVisibility != visible) {
			prefWidthProperty().setValue(visible ? 120 : 0);
			setVisible(visible);

			this.previousVisibility = visible;
		}
	}

}
