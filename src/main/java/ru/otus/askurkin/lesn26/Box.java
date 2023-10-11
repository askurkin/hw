package ru.otus.askurkin.lesn26;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Box<T extends Fruit> {
	List<T> fruits;

	public List<T> getFruits() {
		return fruits;
	}

	public Box() {
		this.fruits = new ArrayList();
	}

	public boolean put(T element) {
		fruits.add(element);
		return true;
	}

	public int weight() {
		int sumWeight = 0;

		for (T fruit : fruits) {
			sumWeight += fruit.getWeight();
		}

		return sumWeight;
	}

	public boolean compare(Box<? extends Fruit> others) {
		return this.weight() == others.weight();
	}

	public void copyFrom(Box<? extends Fruit> copy) {
		for (var fruit : copy.getFruits()) {
			this.put(fruit);
		}
	}
}

//		Реализуйте метод, позволяющий пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов в коробках;
