package ru.otus.askurkin.Tapes;

public class Cat {
	private String name;
	private int apetin;

	private boolean full;

	public boolean isFull() {
		return full;
	}

	public Cat(String name, int apetin) {
		this.name = name;
		this.apetin = apetin;
		this.full = false;
	}

	public void eat(Tapes tape) {
		if (!tape.eat(apetin)) {
			System.out.println(name + " не хватает еды");
			return;
		}
		full = true;
		System.out.println(name + " наелся");
	}

	@Override
	public String toString() {
		if (full) {
			return name + " сытый";
		}
		return name + " апетит " + apetin + " голодный";
	}
}
