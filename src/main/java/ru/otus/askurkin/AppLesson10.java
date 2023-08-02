package ru.otus.askurkin;

public class AppLesson10 {

	public static void main(String[] args) {
		String[] names = {"Александр", "Алексей", "Павел", "Иван", "Сергей"};
		String[] famalys = {"Иванов", "Петров", "Сидоров", "Прохоров", "Кузнецов"};
		String[] secondNames = {"Иванович", "Сергеевич", "Николаевич", "Александрович", "Петрович"};

		User[] users = new User[10];
		for (int i = 0; i < users.length; i++) {
			users[i] = new User(
					famalys[random(famalys.length)],
					names[random(names.length)],
					secondNames[random(secondNames.length)],
					2000 - random(40),
					"email" + i + "@mail.ru");
		}

		for (int i = 0; i < users.length; i++) {
			if (users[i].howOld() > 40) {
				users[i].showInfo();
			}
		}

		Box b1 = new Box("BOX", 1 + random(5), "blue");
		b1.open();
		b1.open();
		b1.addItem("вещь");
		b1.addItem("вещь2");
		b1.info();
		b1.close();
		b1.dropItem();
		b1.open();
		b1.dropItem();
		b1.dropItem();
	}

	public static int random(int Max) {
		return (int) (Math.random() * Max);
	}


}
