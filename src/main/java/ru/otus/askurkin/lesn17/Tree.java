package ru.otus.askurkin.lesn17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tree<T> implements SearchTree<T> {

	T element;
	private List<Tree<T>> childrens = new ArrayList<>();

	public Tree(T element) {
		this.element = element;
	}

	public List<Tree<T>> getChildrens() {
		return childrens;
	}

	public void setChildrens(List<Tree<T>> childrens) {
		this.childrens = childrens;
	}

	@Override
	public String toString() {
		return element.toString();
	}

	@Override
	public int hashCode() {
		return element.hashCode();
	}

	private Tree<T> findInTree(Tree<T> tree, T findElement) {
		Tree<T> find;
		if (tree.element == findElement) {
			return tree;
		}
		for (Tree<T> children : tree.getChildrens()) {
			find = findInTree(children, findElement);
			if (find != null) {
				return find;
			}
		}
		return null;
	}

	@Override
	public T find(T element) {
		Tree<T> findElement;
		findElement = findInTree(this, element);
		if (findElement != null) {
			return findElement.element;
		}
		return null;
	}

	private List<Tree<T>> toList(Tree<T> tree) {
		List<Tree<T>> list = new ArrayList<>();

		list.add(tree);
		for (Tree<T> children : tree.getChildrens()) {
			list.addAll(toList(children));
		}
		return list;
	}

	@Override
	public List getSortedList() {
		List<Tree<T>> list = toList(this);

		Set<T> set = new HashSet<>();

		for (Tree<T> tTree : list) {
			set.add(tTree.element);
		}

		return Arrays.asList(set.toArray());
	}
}
