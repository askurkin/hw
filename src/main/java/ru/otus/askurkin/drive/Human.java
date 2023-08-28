package ru.otus.askurkin.drive;

public class Human {
	private String name;
	TransportMove currentTransportMove;

	public TransportMove getCurrentTransportMove() {
		return currentTransportMove;
	}

	public void setCurrentTransport(TransportMove currentTransportMove) {
		if (currentTransportMove == null) {
			if (this.currentTransportMove != null) {
				System.out.println(name + " покину " + this.currentTransportMove);
				this.currentTransportMove = null;
			}
			return;
		}
		if (this.currentTransportMove == currentTransportMove) {
			System.out.println(name + " уже сижу в " + currentTransportMove);
			return;
		}
		if (this.currentTransportMove == null) {
			System.out.println(name + " использует " + currentTransportMove);
			this.currentTransportMove = currentTransportMove;
			return;
		}
		System.out.println(name + " сменил " + this.currentTransportMove + " на " + currentTransportMove);
		this.currentTransportMove = currentTransportMove;
	}

	public Human(String name) {
		this.name = name;
	}

	public boolean move(PlaceType placeType, int distance) {
		if (currentTransportMove != null) {
			return currentTransportMove.move(placeType, distance);
		}
		System.out.println("Идём пешком " + placeType.getDesc() + " " + distance);
		return true;
	}
}
