package ru.otus.askurkin;

import ru.otus.askurkin.lesn15.Person;

import java.util.ArrayList;
import java.util.List;

public class AppLesson15 {

	public static void main(String[] args) {

		System.out.println(createList(4, 10));

		ArrayList<Integer> arr2 = new ArrayList<>();
		arr2.add(3);
		arr2.add(7);
		arr2.add(9);
		arr2.add(10);
		System.out.println(arr2);
		System.out.println(sumElMoreThen5(arr2));

		addToAll(4, arr2);
		System.out.println(arr2);

		List<Person> arr4 = new ArrayList<>();

		arr4.add(new Person("Test1", 30));
		arr4.add(new Person("Test2", 40));

		System.out.println(personNames(arr4));

		System.out.println(getPersonAgeMoreWhen(arr4, 40));

		System.out.println(checkAvgAge(arr4, 34));

		System.out.println(getYongest(arr4));
	}

	public static List<Integer> createList(int min, int max) {
		List<Integer> arr = new ArrayList<>();
		for (int i = min; i <= max; i++) {
			arr.add(i);
		}
		return arr;
	}

	public static int sumElMoreThen5(List<Integer> arr) {
		int sum = 0;

		for (Integer i : arr) {
			if (i > 5) {
				sum += i;
			}

		}

		return sum;
	}

	public static void addToAll(int add, List<Integer> arr) {
		for (int i = 0; i < arr.size(); i++) {
			arr.set(i, arr.get(i) + add);
		}
	}

	public static List<String> personNames(List<Person> arr) {
		List<String> names = new ArrayList<>();
		for (Person person : arr) {
			names.add(person.getName());
		}

		return names;
	}

	public static List<Person> getPersonAgeMoreWhen(List<Person> arr, int age) {
		List<Person> arrMore = new ArrayList<>();

		for (Person pers : arr) {
			if (pers.getAge() >= age) {
				arrMore.add(pers);
			}
		}

		return arrMore;
	}

	public static boolean checkAvgAge(List<Person> arr, int avgAge) {
		int avg = 0;

		if (arr.size() == 0) {
			return false;
		}

		for (Person pers : arr) {
			avg += pers.getAge();
		}

		avg /= arr.size();

		return avg > avgAge;
	}

	public static Person getYongest(List<Person> arr) {
		if (arr.size() == 0) {
			return null;
		}

		int idx = 0;
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(idx).getAge() > arr.get(i).getAge()) {
				idx = i;
			}
		}

		return arr.get(idx);
	}

}
