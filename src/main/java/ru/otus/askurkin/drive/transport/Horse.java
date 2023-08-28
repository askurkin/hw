package ru.otus.askurkin.drive.transport;

import ru.otus.askurkin.drive.PlaceType;
import ru.otus.askurkin.drive.TransportMove;

public class Horse implements TransportMove {
	private String name;
	private int strong;
	private final int rashod = 1;

	public Horse(String name, int strong) {
		this.name = name;
		this.strong = strong;
	}

	@Override
	public boolean move(PlaceType placeType, int distance) {
		if (!placeType.getAble(this)) {
			System.out.println(name + " не двигается по " + placeType.getDesc());
			return false;
		}
		int tryDistance = distance / rashod;
		if (tryDistance > strong) {
			System.out.println(name + " не хватило сил");
			return false;
		}
		strong -= tryDistance;
		System.out.println(name + " проскакали " + distance + " по " + placeType.getDesc());
		return true;
	}

	@Override
	public String toString() {
		return name + " силы " + strong;
	}
}
