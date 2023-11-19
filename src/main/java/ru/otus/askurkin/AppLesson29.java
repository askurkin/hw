package ru.otus.askurkin;

public class AppLesson29 {
	public final static Object monitor = new Object();
	public static int sequence = 0;

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				synchronized (monitor) {
					try {
						while (AppLesson29.sequence != 0) {
							monitor.wait();
						}
						AppLesson29.printA();
						AppLesson29.sequence = 1;
						monitor.notifyAll();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				synchronized (monitor) {
					try {
						while (AppLesson29.sequence != 1) {
							monitor.wait();
						}
						AppLesson29.printB();
						AppLesson29.sequence = 2;
						monitor.notifyAll();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
		});
		Thread t3 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				synchronized (monitor) {
					try {
						while (AppLesson29.sequence != 2) {
							monitor.wait();
						}
						AppLesson29.printC();
						AppLesson29.sequence = 0;
						monitor.notifyAll();
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
				}
			}
		});
		t1.start();
		t2.start();
		t3.start();
		t1.join();
		t2.join();
		t3.join();
	}

	public static void printA() {
		System.out.print("A");
	}

	public static void printB() {
		System.out.print("B");
	}

	public static void printC() {
		System.out.print("C");
	}
}
