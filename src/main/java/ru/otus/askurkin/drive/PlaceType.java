package ru.otus.askurkin.drive;

import ru.otus.askurkin.drive.transport.Car;
import ru.otus.askurkin.drive.transport.Horse;
import ru.otus.askurkin.drive.transport.OffRoad;
import ru.otus.askurkin.drive.transport.Velo;

public enum PlaceType {
	FOREST("Лес"), LAND("Поле"), SWAMP("Болото");

	private String desc;

	public String getDesc() {
		return desc;
	}

	public boolean getAble(Object object) {
		if (object == null) {
			return true;
		}
		if (object instanceof Car) {
			if (this == PlaceType.LAND) {
				return true;
			}
			return false;
		}
		if (object instanceof Horse || object instanceof Velo) {
			if (this == PlaceType.SWAMP) {
				return false;
			}
			return true;
		}
		if (object instanceof OffRoad) {
			return true;
		}
		return false;
	}

	PlaceType(String desc) {
		this.desc = desc;
	}
}
