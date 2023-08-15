package ru.otus.askurkin;

import ru.otus.askurkin.exceptions.AppArrayDataException;
import ru.otus.askurkin.exceptions.AppArraySizeException;

public class AppLesson14 {
	public static void main(String[] args) {
		String[][] arr = new String[][]{
				{"123", "456", "123", "234"},
				{"123", "23576", "99","f22"},
				{"22", "2", "87", "67"},
				{"09", "78", "99", "56"}};

		try {
			System.out.println("Sum="+func(arr));
		} catch (AppArraySizeException ex) {
			System.out.println("Проблемы с размером массива");
		} catch (AppArrayDataException ex) {
			System.out.println("Проблемы с данным");
		}
	}

	public static int func(String[][] array) throws AppArraySizeException, AppArrayDataException {
		final int SIZE = 4;
		int sum = 0;

		if (array.length != SIZE) {
			throw new AppArraySizeException();
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i].length != SIZE) {
				throw new AppArraySizeException();
			}
		}

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				try {
					sum += Integer.parseInt(array[i][j]);
				} catch (Exception ex) {
					throw new AppArrayDataException("Ошибка данных в массиве i=" + i + "; j=" + j);
				}
			}
		}

		return sum;
	}
}
