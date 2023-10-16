package ru.otus.askurkin.lesn26;

public class Fruit {
	int weight;
	private String name;

	public int getWeight() {
		return weight;
	}

	public Fruit(int weight) {
		this.weight = weight;
		String[] str = this.getClass().toString().split("\\.");
		name = str[str.length - 1];
	}

	@Override
	public String toString() {
		return name + "(" + weight + ')';
	}
}
