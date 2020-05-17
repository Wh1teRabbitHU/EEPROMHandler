package hu.thewhiterabbit.eeprom.handler.util;

public final class MathUtil {

	private MathUtil() {
	}

	public static String paddedBinary(Integer number, int padding) {
		boolean negative = number < 0;

		if (negative) {
			number *= -1;
			padding -= 1;
		}

		StringBuilder stringValue = new StringBuilder(number.toString());
		int stringLength = stringValue.length();

		for (int i = 0; i < padding - stringLength; i++) {
			stringValue.insert(0, "0");
		}

		if (negative) {
			stringValue.insert(0, "-");
		}

		return stringValue.toString();
	}

}
