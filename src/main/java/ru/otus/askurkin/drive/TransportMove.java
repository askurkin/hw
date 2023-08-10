package ru.otus.askurkin.drive;

@FunctionalInterface
public interface TransportMove {
	boolean move(PlaceType placeType, int distance);
}
