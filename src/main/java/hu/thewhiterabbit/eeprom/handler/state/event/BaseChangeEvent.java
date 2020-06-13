package hu.thewhiterabbit.eeprom.handler.state.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

@Getter
public abstract class BaseChangeEvent<T> extends ApplicationEvent {

	private final T changedData;

	public BaseChangeEvent(final Object source, final T changedData) {
		super(source);

		this.changedData = changedData;
	}

}
