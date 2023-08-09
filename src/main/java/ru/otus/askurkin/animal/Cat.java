package ru.otus.askurkin.animal;

public class Cat extends Animal {
	public Cat(String name, int strong) {
		super(name, strong);
		this.speedRun = 5;
		this.speedSwim = 0;
	}

	@Override
	public int swim(int distance) {
		System.out.println(name + " не умеет плавать");
		return -1;
	}
}
