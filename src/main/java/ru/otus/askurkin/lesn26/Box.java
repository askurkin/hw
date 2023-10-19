package ru.otus.askurkin.lesn26;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
	private List<T> fruits;
	public static int count = 0;
	private String name;

	public List<T> getFruits() {
		return fruits;
	}

	public Box() {
		this.fruits = new ArrayList();
		this.name = "Box" + (count++);
	}

	@Override
	public String toString() {
		return name + fruits.toString();
	}

	public <F extends T> void add(F element) {
		fruits.add(element);
	}

	public void remove(T element) {
		fruits.remove(element);
	}

	public int weight() {
		int sumWeight = 0;

		for (T fruit : fruits) {
			sumWeight += fruit.weight;
		}

		return sumWeight;
	}

	public boolean compare(Box<? extends Fruit> others) {
		return this.weight() == others.weight();
	}

	public void moveTo(Box<? super T> boxTo) {
		if (this == boxTo || this.fruits == null) {
			return;
		}
		for (T fruit : this.fruits) {
			boxTo.add(fruit);
		}
		fruits.clear();
	}
}
