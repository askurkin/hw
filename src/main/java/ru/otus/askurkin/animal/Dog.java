package ru.otus.askurkin.animal;

public class Dog extends Animal {
	public Dog(String name, int strong) {
		super(name, strong);
		this.speedRun = 4;
		this.speedSwim = 5;
		this.strongSwim = 2;
	}
}
