package ru.otus.askurkin.Tapes;

public class Tapes {
	private int maxFood = 100;
	private int food;

	public Tapes(int maxFeed) {
		this.maxFood = maxFeed;
		this.food = maxFeed;
	}

	public void appendFood(int food) {
		this.food += food;
		if (this.food > maxFood) {
			this.food = maxFood;
		}
	}

	public boolean eat(int food) {
		if (this.food - food < 0) {
			return false;
		}
		this.food -= food;
		return true;
	}

	@Override
	public String toString() {
		return "food = " + food;
	}
}
