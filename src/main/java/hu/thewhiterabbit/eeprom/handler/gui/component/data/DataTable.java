package hu.thewhiterabbit.eeprom.handler.gui.component.data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.model.common.SimpleObservableList;
import hu.thewhiterabbit.eeprom.handler.model.eeprom.Eeprom;
import hu.thewhiterabbit.eeprom.handler.model.eeprom.Sector;
import hu.thewhiterabbit.eeprom.handler.state.event.EepromChangeEvent;
import hu.thewhiterabbit.eeprom.handler.util.MathUtil;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

@Component
public class DataTable extends TableView<Sector> {

	private final TableColumn<Sector, Integer> addressColumn = new TableColumn<>("Starting address");
	private final TableColumn<Sector, Integer> byteValueColumn = new TableColumn<>("Byte value");
	private final List<TableColumn<Sector, ?>> headers = new ArrayList<>();

	private final ObservableList<Sector> sectors = new SimpleObservableList<>();

	@PostConstruct
	public void init() {
		setItems(sectors);

		addressColumn.setCellValueFactory(new PropertyValueFactory<>("hexStartAddress"));
		headers.add(addressColumn);

		for (int address = 0; address < Sector.RANGE_SIZE; address++) {
			final int currentAddress = address;
			TableColumn<Sector, Integer> blockValueColumn = new TableColumn<>("0" + MathUtil.getHex(address));
			blockValueColumn.setCellValueFactory(cellData -> {
				int absoluteAddress = cellData.getValue()
											  .getStartAddress() + currentAddress;

				return cellData.getValue()
							   .getBlock(absoluteAddress)
							   .map(block -> new SimpleIntegerProperty(block.getValue()))
							   .orElse(new SimpleIntegerProperty())
							   .asObject();
			});
			headers.add(blockValueColumn);
		}

		byteValueColumn.setCellValueFactory(new PropertyValueFactory<>("byteValue"));
		headers.add(byteValueColumn);

		getColumns().setAll(headers);
	}

	@EventListener
	public void handleBlockSetChange(EepromChangeEvent eepromChangeEvent) {
		Eeprom eeprom = eepromChangeEvent.getChangedData();

		sectors.clear();

		if (eeprom != null) {
			sectors.addAll(eeprom.getSectors());
		}
	}

}
