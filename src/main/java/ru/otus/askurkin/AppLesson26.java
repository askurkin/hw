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

		boxApple.put(new Apple( 4));

		boxApple.compare(boxFruit);
//		boxApple.put(new Orange(2)); -- err

		boxOrange.put(new Orange( 3));

		boxApple.moveTo(boxFruit);
		boxOrange2.moveTo(boxOrange);
		boxOrange.moveTo(boxApple);

	}
}
