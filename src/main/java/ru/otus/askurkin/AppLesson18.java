package ru.otus.askurkin;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class AppLesson18 {

	public static void main(String[] args) {
		File dir = new File(".");
		for (File file : dir.listFiles()) {
			if (file.isFile() && file.getName().endsWith(".txt")) {
				System.out.println(file.getName());
			}
		}

		Scanner scanner = new Scanner(System.in);
		System.out.print("Введите имя файла: ");
		String fileName = scanner.next();

		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName))) {
			int ch = in.read();
			while (ch != -1) {
				System.out.print((char) ch);
				ch = in.read();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Файл " + fileName + " не найден.");
			return;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		System.out.println("\nВведите текст: ");
		String addString = scanner.next();

		try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName, true))) {
			byte[] buff = ("\n" + addString).getBytes(StandardCharsets.UTF_8);

			out.write(buff, 0, buff.length);

			out.flush();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		System.out.println("Добавили в файл.");
	}
}
