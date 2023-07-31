package ru.otus.askurkin;

public class Box {
	private String name;
	private int size;
	private String color;
	private boolean stateOpen;
	private String item;

	public void setColor(String color) {
		this.color = color;
		System.out.println("Перекрасили " + this.name + " в " + this.color);
	}

	public Box(String name, int size, String color) {
		this.name = name;
		this.size = size;
		this.color = color;
		this.stateOpen = false;
		this.item = null;
		System.out.println("Создали Box");
		info();
	}

	public void info() {
		System.out.println(this.name + " size:" + this.size + " color:" + this.color + " is_open:" + this.stateOpen + " item:" + this.item);
	}

	public void open() {
		if (!this.stateOpen) {
			this.stateOpen = true;
			System.out.println("Открыли " + this.name);
		} else {
			System.out.println("Уже открыто " + this.name);
		}

	}

	public void close() {
		if (this.stateOpen) {
			this.stateOpen = false;
			System.out.println("Закрыли " + this.name);
		} else {
			System.out.println("Уже закрыто " + this.name);
		}
	}

	public void addItem(String item) {
		if (this.stateOpen && this.item == null) {
			this.item = item;
			System.out.println("Добавили в " + this.name + " item:" + this.item);
			return;
		}
		if (!this.stateOpen) {
			System.out.println(this.name + " закрыт");
		} else {
			System.out.println("в " + this.name + " не пусто");
		}
	}

	public void dropItem() {
		if (this.stateOpen && this.item != null) {
			System.out.println("Выбросили из " + this.name + " item:" + this.item);
			this.item = null;
			return;
		}
		if (!this.stateOpen) {
			System.out.println(this.name + " закрыт");
		} else {
			System.out.println("в " + this.name + " пусто");
		}
	}
}
