package hu.thewhiterabbit.eeprom.handler.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class MathUtil {

	private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
	private static final String HEX_PREFIX = "0x";

	private MathUtil() {
	}

	public static String paddedNumber(Integer number, int padding) {
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

	public static String paddedHex(String hex, int padding) {
		boolean hasPrefix = hex.startsWith(HEX_PREFIX);

		if (hasPrefix) {
			hex = hex.replaceFirst(HEX_PREFIX, "");
		}

		StringBuilder stringValue = new StringBuilder(hex);
		int stringLength = stringValue.length();

		for (int i = 0; i < padding - stringLength; i++) {
			stringValue.insert(0, "0");
		}

		if (hasPrefix) {
			stringValue.insert(0, HEX_PREFIX);
		}

		return stringValue.toString();
	}

	public static String getHex(int number) {
		return getHex(number, false);
	}

	public static String getHex(int number, boolean hasPrefix) {
		String hex = Integer.toHexString(number)
							.toUpperCase();

		if (hasPrefix) {
			return HEX_PREFIX + hex;
		}

		return hex;
	}

	public static String getByteString(int data) {
		return getByteString((byte) data);
	}

	public static String getByteString(byte data) {
		return getByteString(new byte[] { data });
	}

	public static String getByteString(byte[] data) {
		return new String(data, DEFAULT_CHARSET);
	}

	public static int calculatePercentage(int current, int max) {
		if (current == 0) {
			return 0;
		}

		return current * 100 / max;
	}

}
