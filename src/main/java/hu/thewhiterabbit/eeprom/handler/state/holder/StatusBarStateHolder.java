package hu.thewhiterabbit.eeprom.handler.state.holder;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.state.event.PercentageChangeEvent;
import hu.thewhiterabbit.eeprom.handler.state.event.StatusTextChangeEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Component
@RequiredArgsConstructor
public class StatusBarStateHolder {

	private final ApplicationEventPublisher applicationEventPublisher;

	private int percentage;
	private String statusText;

	public void changePercentage(int percentage) {
		this.percentage = percentage;

		applicationEventPublisher.publishEvent(new PercentageChangeEvent(this, percentage));
	}

	public void changeStatusText(String statusText) {
		this.statusText = statusText;

		applicationEventPublisher.publishEvent(new StatusTextChangeEvent(this, statusText));
	}

}
