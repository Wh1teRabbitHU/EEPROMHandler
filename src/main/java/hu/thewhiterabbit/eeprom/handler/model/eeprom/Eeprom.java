package hu.thewhiterabbit.eeprom.handler.model.eeprom;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import hu.thewhiterabbit.eeprom.handler.model.code.EepromType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Eeprom {

	private final EepromType type;

	private final Set<Sector> sectors = new LinkedHashSet<>();

	public Eeprom(final EepromType type) {
		this.type = type;

		for (int address = 0; address < type.maxAddress; address += Sector.RANGE_SIZE) {
			sectors.add(new Sector(address));
		}
	}

	public Optional<Block> getBlock(int address) {
		Optional<Sector> sector = sectors.stream()
										 .filter(s -> s.getBlock(address)
													   .isPresent())
										 .findFirst();

		if (sector.isEmpty()) {
			return Optional.empty();
		}

		return sector.get()
					 .getBlock(address);
	}

	public void updateBlock(int address, int value) {
		getBlock(address).ifPresent(b -> b.setValue(value));
	}

	public void updateBlock(int address, Block block) {
		getBlock(address).ifPresent(b -> b.copyBlock(block));
	}

}
