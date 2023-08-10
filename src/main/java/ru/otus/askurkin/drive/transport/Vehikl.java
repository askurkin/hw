package ru.otus.askurkin.drive.transport;

public abstract class Vehikl {

	String name;
	int fiel;
	int rashod = 4;

	@Override
	public String toString() {
		return name + " остаток " + fiel;
	}

	public Vehikl(String name, int fiel, int rashod) {
		this.name = name;
		this.fiel = fiel;
		this.rashod = rashod;
	}
}
