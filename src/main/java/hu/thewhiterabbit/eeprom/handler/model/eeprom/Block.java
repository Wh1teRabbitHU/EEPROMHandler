package hu.thewhiterabbit.eeprom.handler.model.eeprom;

import java.util.Objects;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Block {

	private final int address;

	private int value;

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		} else if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		return address == ((Block) o).address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address);
	}

}
