package ru.otus.askurkin;

import ru.otus.askurkin.lesn16.PhoneBook;

public class AppLesson16 {

	public static void main(String[] args) {
		PhoneBook phoneBook = new PhoneBook();

		phoneBook.add("Name1", "Phone1");
		phoneBook.add("Name2", "Phone2");
		phoneBook.add("Name3", "Phone2");
		phoneBook.add("Name1", "Phone3");
		phoneBook.add("Name1", "Phone3");

		System.out.println(phoneBook.find("Name1"));
		System.out.println(phoneBook.find("Name2"));
		System.out.println(phoneBook.find("Name3"));

		System.out.println(phoneBook.containsPhoneNumber("Phone3"));
		System.out.println(phoneBook.containsPhoneNumber("Phone4"));
	}
}
