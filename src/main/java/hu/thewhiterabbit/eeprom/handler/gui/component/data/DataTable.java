package hu.thewhiterabbit.eeprom.handler.gui.component.data;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import hu.thewhiterabbit.eeprom.handler.model.common.SimpleObservableList;
import hu.thewhiterabbit.eeprom.handler.model.eeprom.Block;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

@Component
public class DataTable extends TableView<Block> {

	private final TableColumn<Block, Integer> addressColumn = new TableColumn<>("Address");
	private final TableColumn<Block, Integer> valueColumn = new TableColumn<>("Decimal value");

	private final ObservableList<Block> blocks = new SimpleObservableList<>();

	@PostConstruct
	public void init() {
		blocks.addAll(
				new Block(0, 0),
				new Block(1, 1),
				new Block(2, 2),
				new Block(3, 3)
		);

		setItems(blocks);

		addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
		valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));

		getColumns().setAll(addressColumn, valueColumn);
	}

}
