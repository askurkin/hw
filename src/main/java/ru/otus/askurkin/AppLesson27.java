package ru.otus.askurkin;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class AppLesson27 {
	public static void main(String[] args) throws UnsupportedEncodingException {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Введите имя файла: ");
		String fileName = scanner.next();

		System.out.print("Последовательность символов: ");
		String findStr = scanner.next();
		int strSize = findStr.getBytes("UTF-8").length;
		int countStr = 0;

		try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
			byte[] bytes = new byte[strSize];
			long fileSize = raf.length();
			for (int i = 0; i < fileSize; i++) {
				raf.seek(i);
				int read = raf.read(bytes);
				String str = new String(bytes, 0, read, StandardCharsets.UTF_8);
				if (str.equals(findStr)) {
					countStr += 1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(findStr + " встречается " + countStr + " раз");
	}
}
