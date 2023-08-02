package ru.otus.askurkin;

public abstract class Animal {
	public String name;
	int speedRun;
	int speedSwim;
	int strong;
	final int strongRun = 1;
	int strongSwim;
	boolean ready;

	public Animal(String name, int strong) {
		this.name = name;
		this.strong = strong;
		this.ready = true;
	}

	public int run(int distance) {
		int strongNeed = strongRun * distance;
		if (strong - strongNeed < 0) {
			System.out.println(name + " устал");
			ready = false;
			return -1;
		}
		strong -= strongNeed;
		System.out.println(name + " бежит " + distance);
		return distance / speedRun;
	}

	public int swim(int distance) {
		int strongNeed = strongSwim * distance;
		if (strong - strongNeed < 0) {
			System.out.println(name + " устал");
			ready = false;
			return -1;
		}
		strong -= strongNeed;
		System.out.println(name + " плывёт " + distance);
		return distance / speedSwim;
	}

	public void info() {
		System.out.println("name = " + name + "; strong = " + strong);
	}
}
