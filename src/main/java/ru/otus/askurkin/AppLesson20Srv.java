package ru.otus.askurkin;

import ru.otus.askurkin.lesn20.Lesn20Server;

import java.io.IOException;

public class AppLesson20Srv {
	public static void main(String[] args) throws IOException {
		try (Lesn20Server server = new Lesn20Server(8089)) {
			while (true) {
				String str = server.read();
				System.out.println(str);
				str = server.process(str);
				System.out.println(" = " + str);
				server.push(str);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
