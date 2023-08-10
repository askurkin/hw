package ru.otus.askurkin;

import ru.otus.askurkin.drive.Human;
import ru.otus.askurkin.drive.PlaceType;
import ru.otus.askurkin.drive.TransportMove;
import ru.otus.askurkin.drive.transport.Car;
import ru.otus.askurkin.drive.transport.Horse;
import ru.otus.askurkin.drive.transport.OffRoad;
import ru.otus.askurkin.drive.transport.Velo;

public class AppLesson13 {
	public static void main(String[] args) {
		Human human = new Human("Человек");
		Car car = new Car("Nissan", 50);
		Horse horse = new Horse("Стрелка", 30);
		Velo velo = new Velo("Stels");
		OffRoad offRoad = new OffRoad("UAZ", 80);

		TransportMove[] transportMoves = new TransportMove[]{car, horse, velo, offRoad};
		PlaceType placeType = null;

		// пешком
		human.move(PlaceType.FOREST, random(20) + 10);

		while (true) {
			TransportMove transport = transportMoves[random(transportMoves.length)];
			placeType = PlaceType.values()[random(PlaceType.values().length)];

			human.setCurrentTransport(transport);

			boolean bMove = human.move(placeType, random(20) + 10);

			if (!bMove && placeType.getAble(human.getCurrentTransportMove())) {
				break;
			}
			System.out.println();
		}

		System.out.println();
		for (int i = 0; i < transportMoves.length; i++) {
			System.out.println(transportMoves[i]);
		}
	}

	public static int random(int Max) {
		return (int) (Math.random() * Max);
	}

}
