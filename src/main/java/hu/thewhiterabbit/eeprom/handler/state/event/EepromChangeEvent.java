package hu.thewhiterabbit.eeprom.handler.state.event;

import hu.thewhiterabbit.eeprom.handler.model.eeprom.Eeprom;

public class EepromChangeEvent extends BaseChangeEvent<Eeprom> {

	public EepromChangeEvent(final Object source, final Eeprom changedData) {
		super(source, changedData);
	}

}
