package hu.thewhiterabbit.eeprom.handler.state.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public class StatusTextChangeEvent extends ApplicationEvent {

	private final String statustext;

	public StatusTextChangeEvent(final Object source, final String statustext) {
		super(source);

		this.statustext = statustext;
	}

}
