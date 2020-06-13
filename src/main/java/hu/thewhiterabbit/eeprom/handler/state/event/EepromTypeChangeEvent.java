package hu.thewhiterabbit.eeprom.handler.state.event;

import org.springframework.context.ApplicationEvent;

import hu.thewhiterabbit.eeprom.handler.model.code.EepromType;
import lombok.Getter;

@Getter
public class EepromTypeChangeEvent extends ApplicationEvent {

	private final EepromType eepromType;

	public EepromTypeChangeEvent(final Object source, final EepromType eepromType) {
		super(source);

		this.eepromType = eepromType;
	}

}
