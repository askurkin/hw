package ru.otus.askurkin;

import ru.otus.askurkin.exceptions.AppArrayDataException;
import ru.otus.askurkin.exceptions.AppArraySizeException;

public class AppLesson14 {
	static final int CUBE_SIZE = 4;

	public static void main(String[] args) {
		String[][] arr = new String[][]{
				{"123", "456", "123", "234"},
				{"123", "23576", "99","f22"},
				{"22", "2", "87", "67"},
				{"09", "78", "99", "56"}};

		try {
			System.out.println("Sum="+ sumCube(arr));
		} catch (AppArraySizeException ex) {
			System.out.println("Проблемы с размером массива");
		} catch (AppArrayDataException ex) {
			System.out.println("Проблемы с данным");
			System.out.println(ex);
		}
	}

	public static int sumCube(String[][] array) throws AppArraySizeException, AppArrayDataException {
		int sum = 0;

		if (array.length != CUBE_SIZE) {
			throw new AppArraySizeException();
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i].length != CUBE_SIZE) {
				throw new AppArraySizeException();
			}
		}

		for (int i = 0; i < CUBE_SIZE; i++) {
			for (int j = 0; j < CUBE_SIZE; j++) {
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
