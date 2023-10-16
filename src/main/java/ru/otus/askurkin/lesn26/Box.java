package ru.otus.askurkin.lesn26;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
	private List<T> fruits;

	public List<T> getFruits() {
		return fruits;
	}

	public Box() {
		this.fruits = new ArrayList();
	}

	public boolean put(Fruit element) {
		if (fruits.size() > 0) {
			System.out.println(element.getClass() + " => " + fruits.get(0).getClass());
		}

		if (!(T instanceof Fruit) && !(element instanceof T)) {
			return false;
		}

		fruits.add((T) element);
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

	public boolean moveTo(Box<? extends Fruit> copy) {
		for (T fruit : fruits) {
			System.out.println(fruit.getClass() + " => " + copy.getFruits().get(0).getClass());
			if (copy.put(fruit)) {
				fruits.remove(fruit);
			}
		}
		return true;
	}
}
