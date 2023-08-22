package ru.otus.askurkin.tape;

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

	public void eat(Tape tape) {
		if (full) {
			System.out.println( name + " сыт");
			return;
		}
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
