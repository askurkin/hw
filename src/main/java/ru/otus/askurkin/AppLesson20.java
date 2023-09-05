package ru.otus.askurkin;

import ru.otus.askurkin.lesn20.Lesn20Client;

public class AppLesson20 {
	public static void main(String[] args) {

		try (Lesn20Client client = new Lesn20Client("localhost", 8089)) {
			String str = "5 + 6";
			System.out.println(str + " = " + client.push(str));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

