package hu.thewhiterabbit.eeprom.handler.state.holder;

import java.util.Set;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.model.code.EepromType;
import hu.thewhiterabbit.eeprom.handler.model.eeprom.Block;
import hu.thewhiterabbit.eeprom.handler.state.event.BlockSetChangeEvent;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Component
@RequiredArgsConstructor
public class DataStateHolder {

	private final ApplicationEventPublisher applicationEventPublisher;

	private final EepromType eepromType = EepromType.AT28C64;

	private Set<Block> blocks;

	public void changeBlocks(Set<Block> blocks) {
		this.blocks = blocks;

		applicationEventPublisher.publishEvent(new BlockSetChangeEvent(this, blocks));
	}

}
