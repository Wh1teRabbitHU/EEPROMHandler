package hu.thewhiterabbit.eeprom.handler.state.event;

public class StatusTextChangeEvent extends BaseChangeEvent<String> {

	public StatusTextChangeEvent(final Object source, final String changedData) {
		super(source, changedData);
	}

}
