package ru.otus.askurkin;

import ru.otus.askurkin.lesn20.Lesn20Server;

public class AppLesson20Srv {
	static int port = 8080;

	public static void main(String[] args) {
		try (Lesn20Server server = new Lesn20Server(AppLesson20Srv.port)) {
			while (true) {

				System.out.println("Ready");
				String buff = server.readRequest();
				System.out.println(buff);

				String res = "";
				if (buff.equals("operation")) {
					res = "+ - * /";
				} else {
					res = Lesn20Server.process(buff);
				}
				System.out.println(buff + " = " + res);

				server.push(res);
				System.out.println("Push");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			System.out.println("Stop");
		}
	}
}
