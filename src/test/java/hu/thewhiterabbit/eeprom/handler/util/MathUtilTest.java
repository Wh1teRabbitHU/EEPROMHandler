package hu.thewhiterabbit.eeprom.handler.util;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MathUtilTest {

	static Stream<Arguments> paddedNumberProvider() {
		return Stream.of(
				Arguments.arguments(0, 5, "00000"),
				Arguments.arguments(12, 5, "00012"),
				Arguments.arguments(99999, 5, "99999"),
				Arguments.arguments(1000, 5, "01000"),
				Arguments.arguments(-2, 3, "-02"),
				Arguments.arguments(1234567, 5, "1234567"),
				Arguments.arguments(12, 2, "12"),
				Arguments.arguments(126, 8, "00000126")
		);
	}

	@MethodSource("paddedNumberProvider")
	@ParameterizedTest
	void paddedNumber(Integer number, Integer padding, String expectedOutcome) {
		String outcome = MathUtil.paddedNumber(number, padding);

		Assertions.assertEquals(expectedOutcome, outcome);
	}

}