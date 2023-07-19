package ru.otus.askurkin;

import java.util.Arrays;

public class AppLesson5 {
	public static void main(String[] args) {

		// 1
		int[] arr1 = {1, 2, 3};
		int[] arr2 = {2, 2};
		int[] arr3 = {1, 1, 1, 1, 1};
		System.out.println(Arrays.toString(arraySum(arr1, arr2, arr3)));

		//2
		checkPoint(new int[]{1, 1, 1, 1, 1, 5});
		checkPoint(new int[]{5, 3, 4, -2});
		checkPoint(new int[]{7, 2, 2, 2});
		checkPoint(new int[]{9, 4});

		//3
		System.out.println(checkSort(new int[]{1, 1, 1, 1, 1, 5}, true));
		System.out.println(checkSort(new int[]{5, 3, 4, -2}, true));
		System.out.println(checkSort(new int[]{7, 2, 2, 2}, false));

		//4
		int[] arr4 = {5, 3, 4, -2};
		System.out.println(Arrays.toString(arr4));
		arrayBack(arr4);
		System.out.println(Arrays.toString(arr4));
		int[] arr5 = {5, 3, 0, 4, -2};
		System.out.println(Arrays.toString(arr5));
		arrayBack(arr5);
		System.out.println(Arrays.toString(arr5));
	}

	public static int[] arraySum(int[]... arr) {
		int resultSize = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length > resultSize) {
				resultSize = arr[i].length;
			}
		}

		int[] resultArr = new int[resultSize];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				resultArr[j] += arr[i][j];
			}
		}

		return resultArr;
	}

	public static void checkPoint(int[] arr) {
		int point = -1;

		int sumAll = 0;
		for (int i = 0; i < arr.length; i++) {
			sumAll += arr[i];
		}

		int sumLeft = 0;
		for (int i = 0; i < arr.length; i++) {
			sumLeft += arr[i];
			System.out.print(arr[i] + ", ");
			if (sumLeft == sumAll - sumLeft) {
				point = i;
				System.out.print("|");
			}
		}

		if (point >= 0) {
			System.out.println(" - Найдено");
		} else {
			System.out.println(" - Не найдено");
		}
	}

	public static boolean checkSort(int[] arr, boolean asc) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (asc && arr[i] > arr[i + 1]) {
				return false;
			}
			if (!asc && arr[i] < arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static void arrayBack(int[] arr) {
		int buff;
		for (int i = 0; i < arr.length / 2; i++) {
			buff = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = buff;
		}
	}
}
