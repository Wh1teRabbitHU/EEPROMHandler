package hu.thewhiterabbit.eeprom.handler.state.holder;

import java.util.List;

import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.model.code.EepromType;
import hu.thewhiterabbit.eeprom.handler.model.eeprom.Block;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class DataStateHolder {

	private EepromType eepromType;

	private List<Block> blocks;

}
