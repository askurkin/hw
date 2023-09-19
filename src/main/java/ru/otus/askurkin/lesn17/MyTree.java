package ru.otus.askurkin.lesn17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyTree<T> implements SearchTree<T> {

	T node;
	private List<MyTree<T>> children = new ArrayList<>();

	public MyTree(T node) {
		this.node = node;
	}

	public MyTree() {
		this.node = null;
	}

	public List<MyTree<T>> getChildren() {
		return children;
	}

	public void setChildren(MyTree<T>... child) {
		this.children = List.of(child);
	}

	@Override
	public String toString() {
		return node.toString();
	}

	@Override
	public int hashCode() {
		return node.hashCode();
	}

	public void print(MyTree<T> tree, String add) {
		System.out.println(add + " " + tree.node);
		for (MyTree<T> children : tree.getChildren()) {
			print(children, '*' + add);
		}
	}

	private MyTree<T> loadTree(List<T> list) {
		MyTree<T> root = new MyTree<>();
		if (list.size() == 1) {
			return new MyTree<T>(list.get(0));
		}
		if (list.size() == 2) {
			root.node = list.get(0);
			root.setChildren(new MyTree<>(list.get(1)));
			return root;
		}

		root.node = list.get(list.size() / 2);
		root.setChildren(
				loadTree(list.subList(0, list.size() / 2)),
				loadTree(list.subList(list.size() / 2 + 1, list.size()))
		);

		return root;
	}

	public void loadList(T... list) {
		this.node = list[list.length / 2];
		this.setChildren(
				loadTree(List.of(list).subList(0, list.length / 2)),
				loadTree(List.of(list).subList(list.length / 2 + 1, list.length))
		);
	}

	private MyTree<T> findInTree(MyTree<T> myTree, T findElement) {
		MyTree<T> find;
		if (myTree.node.equals(findElement)) {
			return myTree;
		}
		for (MyTree<T> children : myTree.getChildren()) {
			find = findInTree(children, findElement);
			if (find != null) {
				return find;
			}
		}
		return null;
	}

	@Override
	public T find(T element) {
		MyTree<T> findElement;
		findElement = findInTree(this, element);
		if (findElement != null) {
			return findElement.node;
		}
		return null;
	}

	private List<MyTree<T>> toList(MyTree<T> myTree) {
		List<MyTree<T>> list = new ArrayList<>();

		list.add(myTree);
		for (MyTree<T> children : myTree.getChildren()) {
			list.addAll(toList(children));
		}
		return list;
	}

	@Override
	public List getSortedList() {
		List<MyTree<T>> list = toList(this);

		Set<T> set = new HashSet<>();

		for (MyTree<T> tMyTree : list) {
			set.add(tMyTree.node);
		}

		return Arrays.asList(set.toArray());
	}
}
