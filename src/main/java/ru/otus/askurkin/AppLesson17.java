package ru.otus.askurkin;

import ru.otus.askurkin.lesn17.MyTree;

public class AppLesson17 {

	public static void main(String[] args) {
		Integer[] elements = new Integer[15];
		for (int i = 0; i < 15; i++) {
			elements[i] = i;
		}

		MyTree<Integer> myTree = new MyTree<>();

		System.out.println(elements);
		myTree.loadList(elements);
		myTree.print(myTree, "");

		System.out.println(myTree.find(8));
		System.out.println(myTree.find(20));

		System.out.println(myTree.getSortedList());
	}
}
