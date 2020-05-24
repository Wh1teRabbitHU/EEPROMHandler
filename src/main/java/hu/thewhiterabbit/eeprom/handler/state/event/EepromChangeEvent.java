package hu.thewhiterabbit.eeprom.handler.state.event;

import org.springframework.context.ApplicationEvent;

import hu.thewhiterabbit.eeprom.handler.model.eeprom.Eeprom;
import lombok.Getter;

@Getter
public class EepromChangeEvent extends ApplicationEvent {

	private final Eeprom eeprom;

	public EepromChangeEvent(final Object source, final Eeprom eeprom) {
		super(source);

		this.eeprom = eeprom;
	}

}
