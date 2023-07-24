package ru.otus.askurkin;

public class AppLesson7 {
	public static void main(String[] args) {

		//Реализовать метод sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный двумерный массив, метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0;
		int[][] ar1 = createRandomBox();
		printArray(ar1);
		System.out.println("sumOfPositiveElements = " + sumOfPositiveElements(ar1) + "\n");

		//Реализовать метод, который принимает в качестве аргумента int size и печатает в консоль квадрат из символов * со сторонами соответствующей длины;
		printBox(3 + random(4));

		//Реализовать метод, принимающий в качестве аргумента двумерный целочисленный массив, и зануляющий его диагональные элементы (можете выбрать любую из диагоналей, или занулить обе);
		int[][] ar2 = diagonalsSet0(ar1);
		printArray(ar2);

		//Реализовать метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива;
		System.out.println("findMax = " + findMax(ar2));


		//Реализуйте метод, который считает сумму элементов второй строки двумерного массива, если второй строки не существует, то в качестве результата необходимо вернуть -1
		int row = 2;
		System.out.println("sumElementAtRow(" + row + ") = " + sumElementAtRow(ar2, row));

	}

	public static int random(int Max) {
		return (int) (Math.random() * Max);
	}

	public static void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == 0) {
					System.out.print("=" + array[i][j]);
				} else if (array[i][j] >= 0) {
					System.out.print("+" + array[i][j]);
				} else {
					System.out.print(array[i][j]);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int[][] createRandomBox() {
		int size = 4 + random(3);

		int[][] array = new int[size][size];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = random(10) - 5;
			}
		}

		return array;
	}

	public static int sumOfPositiveElements(int[][] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] > 0) {
					sum += array[i][j];
				}
			}
		}
		return sum;
	}

	public static void printBox(int size) {
		System.out.println("Box size = " + size);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int[][] diagonalsSet0(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (i == j || i == array[i].length - j - 1) {
					array[i][j] = 0;
				}
			}
		}
		return array;
	}

	public static int findMax(int[][] array) {
		int max = array[0][0];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] > max) {
					max = array[i][j];
				}
			}
		}
		return max;
	}

	public static int sumElementAtRow(int[][] array, int row) {
		if (array.length <= row - 1) {
			return -1;
		}
		int sum = 0;
		for (int i = 0; i < array[row - 1].length; i++) {
			sum += array[row - 1][i];
		}
		return sum;
	}
}
