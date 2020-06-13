package hu.thewhiterabbit.eeprom.handler.state.holder;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.model.code.EepromType;
import hu.thewhiterabbit.eeprom.handler.model.eeprom.Eeprom;
import hu.thewhiterabbit.eeprom.handler.state.event.EepromChangeEvent;
import hu.thewhiterabbit.eeprom.handler.state.event.EepromTypeChangeEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Component
@RequiredArgsConstructor
public class EepromStateHolder {

	private final ApplicationEventPublisher applicationEventPublisher;

	private EepromType eepromType = EepromType.TEST;
	private Eeprom eeprom;

	public void changeEeprom(Eeprom eeprom) {
		this.eeprom = eeprom;

		applicationEventPublisher.publishEvent(new EepromChangeEvent(this, eeprom));
	}

	public void changeEepromType(EepromType eepromType) {
		this.eepromType = eepromType;

		applicationEventPublisher.publishEvent(new EepromTypeChangeEvent(this, eepromType));
	}

}
