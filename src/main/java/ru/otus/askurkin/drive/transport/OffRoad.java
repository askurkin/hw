package ru.otus.askurkin.drive.transport;

import ru.otus.askurkin.drive.PlaceType;
import ru.otus.askurkin.drive.TransportMove;

public class OffRoad extends Vehikl implements TransportMove {
	public OffRoad(String name, int fiel) {
		super(name, fiel, 10);
	}

	@Override
	public boolean move(PlaceType placeType, int distance) {
		if (!placeType.getAble(this)) {
			System.out.println(name + " не двигается по " + placeType.getDesc());
			return false;
		}
		int tryDistance = distance / rashod;
		if (tryDistance > fiel) {
			System.out.println(name + " не хватило бензина");
			return false;
		}
		fiel -= tryDistance;
		System.out.println(name + " проехала " + distance + " по " + placeType.getDesc());
		return true;
	}
}
