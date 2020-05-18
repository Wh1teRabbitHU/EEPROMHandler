package hu.thewhiterabbit.eeprom.handler.state.event;

import java.util.Set;

import org.springframework.context.ApplicationEvent;

import hu.thewhiterabbit.eeprom.handler.model.eeprom.Block;
import lombok.Getter;

@Getter
public class BlockSetChangeEvent extends ApplicationEvent {

	private final Set<Block> blocks;

	public BlockSetChangeEvent(final Object source, final Set<Block> blocks) {
		super(source);

		this.blocks = blocks;
	}

}
