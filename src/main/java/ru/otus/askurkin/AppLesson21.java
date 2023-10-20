package ru.otus.askurkin;

public class AppLesson21 {
	public static int step;

	public static void main(String[] args) throws InterruptedException {
		double[] array = new double[100_000_000];
		long time = System.currentTimeMillis();
		for (int i = 0; i < array.length; i++) {
			array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
		}
		System.out.println(System.currentTimeMillis() - time);

		Thread[] threads = new Thread[4];

		for (int j = 0; j < threads.length; j++) {
			AppLesson21.step = j;
			threads[j] = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = (array.length / threads.length * AppLesson21.step); i < (array.length / threads.length * (AppLesson21.step + 1)); i++) {
						array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
					}
				}
			});
		}

		time = System.currentTimeMillis();

		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}

		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}

		System.out.println(System.currentTimeMillis() - time);
	}
}
