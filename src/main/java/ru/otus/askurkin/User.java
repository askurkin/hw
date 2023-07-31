package ru.otus.askurkin;

public class User {
	private String famaly;
	private String name;
	private String secondName;
	private int yearOfBirthDay;
	private String email;

	public String getFamaly() {
		return famaly;
	}

	public void setFamaly(String famaly) {
		this.famaly = famaly;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public int getYearOfBirthDay() {
		return yearOfBirthDay;
	}

	public void setYearOfBirthDay(int yearOfBirthDay) {
		this.yearOfBirthDay = yearOfBirthDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User(String famaly, String name, String secondName, int yearOfBirthDay, String email) {
		this.famaly = famaly;
		this.name = name;
		this.secondName = secondName;
		this.yearOfBirthDay = yearOfBirthDay;
		this.email = email;
	}

	public void showInfo() {
		System.out.println("ФИО: " + this.famaly + " " + this.name + " " + this.secondName);
		System.out.println("Год рождения: " + this.yearOfBirthDay);
		System.out.println("email: " + this.email);
		System.out.println();
	}

	public int howOld() {
		return 2023 - this.yearOfBirthDay;
	}
}
