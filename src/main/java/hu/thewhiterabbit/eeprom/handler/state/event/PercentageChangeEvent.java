package hu.thewhiterabbit.eeprom.handler.state.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class PercentageChangeEvent extends ApplicationEvent {

	private final int percentage;

	public PercentageChangeEvent(final Object source, final int percentage) {
		super(source);

		this.percentage = percentage;
	}

}
