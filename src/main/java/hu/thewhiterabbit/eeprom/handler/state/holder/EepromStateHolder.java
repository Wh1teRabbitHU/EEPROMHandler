package hu.thewhiterabbit.eeprom.handler.state.holder;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.model.eeprom.Eeprom;
import hu.thewhiterabbit.eeprom.handler.state.event.EepromChangeEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Component
@RequiredArgsConstructor
public class EepromStateHolder {

	private final ApplicationEventPublisher applicationEventPublisher;

	private Eeprom eeprom;

	public void changeEeprom(Eeprom eeprom) {
		this.eeprom = eeprom;

		applicationEventPublisher.publishEvent(new EepromChangeEvent(this, eeprom));
	}

}
