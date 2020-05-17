package hu.thewhiterabbit.eeprom.handler.model.eeprom;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import hu.thewhiterabbit.eeprom.handler.model.code.EepromType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Eeprom {

	private final EepromType type;

	private final Set<Block> blocks = new HashSet<>();

	public Optional<Block> getBlock(int address) {
		return blocks.stream()
					 .filter(block -> block.getAddress() == address)
					 .findFirst();
	}

	public void addBlock(Block block) {
		if (blocks.contains(block)) {
			return;
		}

		blocks.add(block);
	}

	public static Eeprom AT28C64() {
		return new Eeprom(EepromType.AT28C64);
	}

	public static Eeprom AT28C256() {
		return new Eeprom(EepromType.AT28C256);
	}

}
