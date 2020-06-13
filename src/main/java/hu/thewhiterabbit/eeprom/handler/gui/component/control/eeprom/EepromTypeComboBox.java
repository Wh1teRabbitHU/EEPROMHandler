package hu.thewhiterabbit.eeprom.handler.gui.component.control.eeprom;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.model.code.EepromType;
import hu.thewhiterabbit.eeprom.handler.model.common.SimpleObservableList;
import hu.thewhiterabbit.eeprom.handler.state.holder.EepromStateHolder;
import javafx.scene.control.ComboBox;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EepromTypeComboBox extends ComboBox<EepromType> {

	private final EepromStateHolder eepromStateHolder;

	@PostConstruct
	public void init() {
		setItems(new SimpleObservableList<>(Arrays.asList(EepromType.values())));
		setValue(EepromType.TEST);

		valueProperty().addListener((obs, oldSp, eepromType) -> eepromStateHolder.changeEepromType(eepromType));
	}

}
