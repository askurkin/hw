package ru.otus.askurkin;

import ru.otus.askurkin.lesn20.Lesn20Client;

public class AppLesson20 {

	static String host = "localhost";
	static int port = 8080;

	public static void main(String[] args) {

		try (Lesn20Client client = new Lesn20Client(host, port)) {
			System.out.println("operation");
			client.push("operation");
			System.out.println("support " + client.pull());
			String str = "5 + 6";
			client.push(str);
			System.out.println(str + " = ");
			System.out.println(str + " = " + client.pull());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}

