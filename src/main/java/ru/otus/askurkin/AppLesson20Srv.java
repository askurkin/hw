package ru.otus.askurkin;

import ru.otus.askurkin.lesn20.Lesn20Server;

public class AppLesson20Srv {
	static int port = 8080;

	public static void main(String[] args) {
		try (Lesn20Server server = new Lesn20Server(AppLesson20Srv.port)) {
			System.out.println("Ready");
			server.start();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			System.out.println("Stop");
		}
	}
}
