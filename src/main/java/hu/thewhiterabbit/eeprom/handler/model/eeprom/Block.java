package hu.thewhiterabbit.eeprom.handler.model.eeprom;

import java.util.Objects;

import hu.thewhiterabbit.eeprom.handler.util.MathUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
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

	public String hexAddress() {
		return MathUtil.getHex(address);
	}

	public String hexValue() {
		return MathUtil.getHex(value);
	}

	public String byteValue() {
		return MathUtil.getByteString(this.value);
	}

	public void copyBlock(Block block) {
		this.value = block.getValue();
	}

}
