package ru.otus.askurkin;

public class AppLesson11 {
	public static void main(String[] args) {
		Animal[] animals = new Animal[3];

		animals[0] = new Cat("Barsik", 100);
		animals[1] = new Dog("Bobik", 200);
		animals[2] = new Horse("Iskra", 500);

		for (int i = 0; i < animals.length; i++) {
			animals[i].info();
		}

		while (animals[0].ready && animals[1].ready && animals[2].ready) {
			for (int i = 0; i < animals.length; i++) {
				int second;
				second = animals[i].run(random(200));
				second = animals[i].swim(random(200));
			}
		}

		for (int i = 0; i < animals.length; i++) {
			animals[i].info();
		}
	}

	public static int random(int Max) {
		return (int) (Math.random() * Max);
	}
}
