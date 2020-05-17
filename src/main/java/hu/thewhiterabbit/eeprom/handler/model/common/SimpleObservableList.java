package hu.thewhiterabbit.eeprom.handler.model.common;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ModifiableObservableListBase;

public class SimpleObservableList<T> extends ModifiableObservableListBase<T> {

	private final List<T> elements;

	public SimpleObservableList() {
		this.elements = new ArrayList<>();
	}

	public SimpleObservableList(List<T> elements) {
		this.elements = new ArrayList<>();
		this.elements.addAll(elements);
	}

	@Override
	public T get(final int index) {
		return elements.get(index);
	}

	@Override
	public int size() {
		return elements.size();
	}

	@Override
	protected void doAdd(final int index, final T element) {
		elements.add(index, element);
	}

	@Override
	protected T doSet(final int index, final T element) {
		return elements.set(index, element);
	}

	@Override
	protected T doRemove(final int index) {
		return elements.remove(index);
	}

}
