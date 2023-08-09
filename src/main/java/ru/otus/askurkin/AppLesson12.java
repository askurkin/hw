package ru.otus.askurkin;

import ru.otus.askurkin.tape2.Cat;
import ru.otus.askurkin.tape2.Tapes;

public class AppLesson12 {
	public static void main(String[] args) {
		Cat[] cats = new Cat[10];
		for (int i = 0; i < cats.length; i++) {
			cats[i] = new Cat("Кот" + i, AppLesson7.random(100));
		}
		Tapes tape = new Tapes(300);

		System.out.println(tape);
		for (int i = 0; i < cats.length; i++) {
			System.out.println(cats[i]);
		}
		System.out.println();

		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < cats.length; i++) {
				if (!cats[i].isFull()) {
					cats[i].eat(tape);
				}
			}
			tape.appendFood(AppLesson7.random(500));
		}
		System.out.println();

		System.out.println(tape);
		for (int i = 0; i < cats.length; i++) {
			System.out.println(cats[i]);
		}
	}
}


