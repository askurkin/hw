package ru.otus.askurkin;

import java.util.Scanner;

public class AppLesson3 {
	public static void main(String[] args) {

		System.out.println("Task(1)");
		greetings();

		System.out.println("Task(2)");
		checkSign(1, 2, 3);

		System.out.println("Task(3)");
		selectColor();

		System.out.println("Task(4)");
		compareNumbers();

		System.out.println("Task(5)");
		addOrSubtractAndPrint(3, 6, true);

		System.out.println("Task(*)");
		taskStar();
	}

	public static void greetings() {
		System.out.println("Hello\nWorld\nfrom\nJava");
	}

	public static void checkSign(int a, int b, int c) {
		int result = a + b + c;
		if (result >= 0) {
			System.out.println("Сумма положительная");
		} else {
			System.out.println("Сумма отрицательная");
		}
	}

	public static void selectColor() {
		int data = 12;
		if (data <= 10) {
			System.out.println("Красный");
		} else if (data <= 20) {
			System.out.println("Желтый");
		} else {
			System.out.println("Зеленый");
		}
	}

	public static void compareNumbers() {
		int a = 1;
		int b = 2;
		if (a >= b) {
			System.out.println("a >= b");
		} else {
			System.out.println("a < b");
		}
	}

	public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
		int result;
		if (increment) {
			result = initValue + delta;
		} else {
			result = initValue - delta;
		}
		System.out.println("result = " + result);
	}

	public static void taskStar() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Введите число от 1 до 5: ");
		int valIn = scan.nextInt();

		System.out.println("TaskStar(" + valIn + ")");
		if (valIn == 1) {
			greetings();
		}
		if (valIn == 2) {
			int a = (int) (Math.random() * 100) - 50;
			int b = (int) (Math.random() * 100) - 50;
			int c = (int) (Math.random() * 100) - 50;
			checkSign(a, b, c);
		}
		if (valIn == 3) {
			selectColor();
		}
		if (valIn == 4) {
			compareNumbers();
		}
		if (valIn == 5) {
			int val1 = (int) (Math.random() * 100) - 50;
			int val2 = (int) (Math.random() * 100) - 50;
			boolean val3 = (Math.random() * 2 == 1);
			addOrSubtractAndPrint(val1, val2, val3);
		}
	}
}
