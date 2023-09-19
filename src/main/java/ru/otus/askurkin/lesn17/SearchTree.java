package ru.otus.askurkin.lesn17;

import java.util.List;

public interface SearchTree<T> {

	/**
	 * @param element to find
	 * @return element if exists, otherwise - null
	 */

	T find(T element);

	List getSortedList();
}
