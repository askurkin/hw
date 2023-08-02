package ru.otus.askurkin;

public class Horse extends Animal {
	public Horse(String name, int strong) {
		super(name, strong);
		this.speedRun = 10;
		this.speedSwim = 4;
		this.strongSwim = 4;
	}
}
