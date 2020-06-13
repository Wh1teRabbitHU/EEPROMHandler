package hu.thewhiterabbit.eeprom.handler.state.holder;

import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.model.code.EepromType;
import hu.thewhiterabbit.eeprom.handler.model.eeprom.Eeprom;
import hu.thewhiterabbit.eeprom.handler.state.event.EepromChangeEvent;
import hu.thewhiterabbit.eeprom.handler.state.event.EepromTypeChangeEvent;
import lombok.Getter;

@Getter
@Component
public class EepromStateHolder extends BaseStateHolder {

	private EepromType eepromType = EepromType.TEST;
	private Eeprom eeprom;

	public void changeEeprom(Eeprom eeprom) {
		this.eeprom = eeprom;

		publishEvent(new EepromChangeEvent(this, eeprom));
	}

	public void changeEepromType(EepromType eepromType) {
		this.eepromType = eepromType;

		publishEvent(new EepromTypeChangeEvent(this, eepromType));
	}

}
