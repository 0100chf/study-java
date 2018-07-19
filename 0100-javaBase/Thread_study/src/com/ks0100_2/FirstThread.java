
package com.ks0100_2;

// 通过继承Thread类来创建线程类
public class FirstThread extends Thread {
	private int i;

	// 重写run方法，run方法的方法体就是线程执行体
	public void run() {
		for (; i < 100; i++) {
			// 当线程类继承Thread类时，直接使用this即可获取当前线程
			// Thread对象的getName()返回当前该线程的名字
			// 因此可以直接调用getName()方法返回当前线程的名字
			System.out.println(getName() + " " + i);
			if(i==99){
				System.out.println(getName() + " " +"运行完毕");
			}
		}
	}

	public static void main(String[] args) {
		for (int ii = 0; ii < 100; ii++) {
			// 调用Thread的currentThread方法获取当前线程，这就是主线程，main()方法被执行的线程
			System.out.println(Thread.currentThread().getName() + " " + ii);
			//主线程main 先循环到20次，再启动两个子线程
			if (ii == 20) {
				// 创建、并启动第一条线程
				new FirstThread().start();
				// 创建、并启动第二条线程
				new FirstThread().start();
			}
		}
	}
}
