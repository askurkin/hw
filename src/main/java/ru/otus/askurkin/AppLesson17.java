package ru.otus.askurkin;

import ru.otus.askurkin.lesn17.Tree;

import java.util.List;

public class AppLesson17 {

	public static void main(String[] args) {
		int[] element = new int[15];
		int idx = 0;
		for (int i = 0; i < element.length; i++) {
			element[i] = i;
		}

		Tree<Integer> tree_root = new Tree<>(element[idx++]);

		Tree<Integer>[] tree_c1 = new Tree[2];
		for (int i = 0; i < tree_c1.length; i++) {
			tree_c1[i] = new Tree<>(element[idx++]);
		}

		Tree<Integer>[] tree_c2 = new Tree[4];
		for (int i = 0; i < tree_c2.length; i++) {
			tree_c2[i] = new Tree<>(element[idx++]);
		}

		Tree<Integer>[] tree_c3 = new Tree[8];
		for (int i = 0; i < tree_c3.length; i++) {
			tree_c3[i] = new Tree<>(element[idx++]);
		}

		tree_root.setChildrens(List.of(tree_c1));

		for (int i = 0; i < tree_c1.length; i++) {
			tree_c1[i].setChildrens(List.of(tree_c2[i * 2], tree_c2[i * 2 + 1]));
		}
		for (int i = 0; i < tree_c2.length; i++) {
			tree_c2[i].setChildrens(List.of(tree_c3[i * 2], tree_c3[i * 2 + 1]));
		}

		System.out.println(tree_root.find(8));
		System.out.println(tree_root.find(20));

		System.out.println(tree_root.getSortedList());
	}
}
