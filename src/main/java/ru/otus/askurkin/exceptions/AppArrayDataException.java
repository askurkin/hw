package ru.otus.askurkin.exceptions;

public class AppArrayDataException extends Exception {
	private String message;

	public AppArrayDataException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
