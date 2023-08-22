package ru.otus.askurkin.tape;

public class Tape {
	private int maxFood = 100;
	private int food;

	public Tape(int initFood, int maxFood) {
		this.maxFood = maxFood;
		food = initFood;
		if (initFood > maxFood) {
			food = maxFood;
		}
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
