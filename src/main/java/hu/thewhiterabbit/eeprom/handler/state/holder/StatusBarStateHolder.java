package hu.thewhiterabbit.eeprom.handler.state.holder;

import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.state.event.PercentageChangeEvent;
import hu.thewhiterabbit.eeprom.handler.state.event.StatusTextChangeEvent;
import lombok.Getter;

@Getter
@Component
public class StatusBarStateHolder extends BaseStateHolder {

	private int percentage;
	private String statusText;

	public void changePercentage(int percentage) {
		this.percentage = percentage;

		publishEvent(new PercentageChangeEvent(this, percentage));
	}

	public void changeStatusText(String statusText) {
		this.statusText = statusText;

		publishEvent(new StatusTextChangeEvent(this, statusText));
	}

}
