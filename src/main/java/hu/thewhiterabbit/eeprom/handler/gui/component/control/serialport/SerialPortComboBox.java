package hu.thewhiterabbit.eeprom.handler.gui.component.control.serialport;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.fazecast.jSerialComm.SerialPort;

import hu.thewhiterabbit.eeprom.handler.model.common.SimpleObservableList;
import hu.thewhiterabbit.eeprom.handler.service.common.SerialPortService;
import hu.thewhiterabbit.eeprom.handler.state.holder.SerialPortStateHolder;
import javafx.scene.control.ComboBox;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SerialPortComboBox extends ComboBox<SerialPort> {

	private final SerialPortService serialPortService;
	private final SerialPortStateHolder serialPortStateHolder;

	@PostConstruct
	public void init() {
		List<SerialPort> availablePorts = serialPortService.getAvailablePorts();

		setItems(new SimpleObservableList<>(availablePorts));

		valueProperty().addListener((obs, oldSp, serialPort) -> serialPortStateHolder.changeSerialPort(serialPort));
	}

}
