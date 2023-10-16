package ru.otus.askurkin;

import ru.otus.askurkin.lesn26.Apple;
import ru.otus.askurkin.lesn26.Box;
import ru.otus.askurkin.lesn26.Fruit;
import ru.otus.askurkin.lesn26.Orange;

public class AppLesson26 {

	public static void main(String[] args) {
		Box<Fruit> boxFruit = new Box<>();
		Box<Orange> boxOrange = new Box<>();
		Box<Orange> boxOrange2 = new Box<>();
		Box<Apple> boxApple = new Box<>();

		boxFruit.put(new Fruit(2));
		boxFruit.put(new Orange(2));
		System.out.println("boxFruit = " + boxFruit.getFruits() + "\n");

		boxApple.put(new Apple(4));
		System.out.println("boxApple = " + boxApple.getFruits() + "\n");

		System.out.println("boxApple.compare(boxFruit) = " + boxApple.compare(boxFruit) + "\n");

//		boxApple.put(new Orange(2));
//		System.out.println("boxApple = " + boxApple.getFruits() + "\n");

		boxOrange.put(new Orange(3));
		System.out.println("boxOrange + Orange = " + boxOrange.getFruits() + "\n");

		boxApple.moveTo(boxFruit);
		System.out.println("boxFruit + boxApple = " + boxFruit.getFruits() + "\n");

		boxOrange2.moveTo(boxOrange);
		try {
			boxOrange.moveTo(boxApple);
			System.out.println("boxOrange.moveTo(boxApple); - нельзя !!");
		} catch (Exception e) {
			System.out.println("Всё верно boxOrange.moveTo(boxApple); нельзя");
		}

	}
}
