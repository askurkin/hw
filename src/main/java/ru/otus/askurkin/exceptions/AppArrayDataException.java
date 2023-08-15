package ru.otus.askurkin.exceptions;

public class AppArrayDataException extends RuntimeException {
	public AppArrayDataException(String info) {
		super();
		System.err.println(info);
	}
}
