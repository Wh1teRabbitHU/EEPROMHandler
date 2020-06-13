package hu.thewhiterabbit.eeprom.handler.state.event;

import hu.thewhiterabbit.eeprom.handler.model.code.EepromType;

public class EepromTypeChangeEvent extends BaseChangeEvent<EepromType> {

	public EepromTypeChangeEvent(final Object source, final EepromType changedData) {
		super(source, changedData);
	}

}
