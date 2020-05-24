package hu.thewhiterabbit.eeprom.handler.model.code;

public enum EepromType {
	TEST(128),
	AT28C64(8192),
	AT28C256(32768);

	public final int maxAddress;

	EepromType(final int maxAddress) {
		this.maxAddress = maxAddress;
	}
}
