package ru.otus.askurkin.drive.transport;

import ru.otus.askurkin.drive.PlaceType;
import ru.otus.askurkin.drive.TransportMove;

public class Velo implements TransportMove {
	private String name;

	public Velo(String name) {
		this.name = name;
	}

	@Override
	public boolean move(PlaceType placeType, int distance) {
		if (!placeType.getAble(this)) {
			System.out.println(name + " не двигается по " + placeType.getDesc());
			return false;
		}
		System.out.println(name + " проехали " + distance + " по " + placeType.getDesc());
		return true;
	}

	@Override
	public String toString() {
		return name;
	}
}
