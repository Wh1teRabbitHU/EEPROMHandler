package hu.thewhiterabbit.eeprom.handler.model.eeprom;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import hu.thewhiterabbit.eeprom.handler.util.MathUtil;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sector {

	public static final int RANGE_SIZE = 16;

	private final int startAddress;

	private final int endAddress;

	private final List<Block> blocks = new ArrayList<>();

	public Sector(int startAddress) {
		this.startAddress = startAddress;
		this.endAddress = startAddress + RANGE_SIZE - 1;

		for (int address = this.startAddress; address <= this.endAddress; address++) {
			blocks.add(new Block(address, -1));
		}
	}

	public Optional<Block> getBlock(int address) {
		return this.blocks.stream()
						  .filter(block -> Objects.equals(block.getAddress(), address))
						  .findFirst();
	}

	public Optional<String> hexValue(int address) {
		return getBlock(address).map(block -> MathUtil.getHex(block.getValue()));
	}

	public String getHexStartAddress() {
		return MathUtil.paddedHex(MathUtil.getHex(startAddress, true), 4);
	}

	public String getHexValue() {
		return this.blocks.stream()
						  .map(block -> MathUtil.getHex(block.getValue()))
						  .reduce((s, s2) -> s + " " + s2)
						  .orElse("");
	}

	public String getByteValue() {
		return this.blocks.stream()
						  .map(block -> new String(new byte[] { (byte) block.getValue() }, UTF_8))
						  .reduce((s, s2) -> s + " " + s2)
						  .orElse("");
	}

	public boolean containsAddress(int address) {
		return startAddress <= address && endAddress >= address;
	}

}
