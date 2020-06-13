package hu.thewhiterabbit.eeprom.handler.state.event;

public class PercentageChangeEvent extends BaseChangeEvent<Integer> {

	public PercentageChangeEvent(final Object source, final Integer changedData) {
		super(source, changedData);
	}

}
