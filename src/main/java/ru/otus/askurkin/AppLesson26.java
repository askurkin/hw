package ru.otus.askurkin;

import ru.otus.askurkin.lesn26.Apple;
import ru.otus.askurkin.lesn26.Box;
import ru.otus.askurkin.lesn26.Fruit;
import ru.otus.askurkin.lesn26.Orange;

public class AppLesson26 {

	public static void main(String[] args) {
		Box<Fruit> boxFruit = new Box<>();
		Box<Apple> boxApple = new Box<>();
		Box<Orange> boxOrange = new Box<>();
		Box<Orange> boxOrange2 = new Box<>();

		boxFruit.add(new Fruit(2));
		boxFruit.add(new Orange(2));
		System.out.println("boxFruit = " + boxFruit);

		boxApple.add(new Apple(4));
		System.out.println("boxApple = " + boxApple);

		System.out.println("boxApple.compare(boxFruit) = " + boxApple.compare(boxFruit));

//		boxApple.add(new Orange(2));

		boxOrange.add(new Orange(3));
		System.out.println("boxOrange = " + boxOrange);

		boxOrange.moveTo(boxOrange2);
		boxApple.moveTo(boxFruit);
//		boxOrange.moveTo(boxApple);

		//
		System.out.println("\nboxFruit = " + boxFruit);
		System.out.println("boxApple = " + boxApple);
		System.out.println("boxOrange = " + boxOrange);
		System.out.println("boxOrange2 = " + boxOrange2);
	}
}
