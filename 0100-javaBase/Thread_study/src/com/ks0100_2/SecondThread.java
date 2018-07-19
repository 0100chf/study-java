
package com.ks0100_2;

// 通过实现Runnable接口来创建线程类
public class SecondThread implements Runnable {
	private int i;

	// run方法同样是线程执行体
	public void run() {
		for (; i < 100; i++) {
			// 当线程类实现Runnable接口时，
			// 如果想获取当前线程，只能用Thread.currentThread()方法。
			//FirstThread 可以用this，或直接用getName()
			String name=Thread.currentThread().getName();
			System.out.println(name+ "  " + i);//区别FirstThread（1）
			if(i==99){
				System.out.println(name + " " +"运行完毕");//本质区别，SecondThread会共享变量i，而FirstThread不会
			}
		}
	}

	public static void main(String[] args) {
		for (int ii = 0; ii < 100; ii++) {
		//	System.out.println(Thread.currentThread().getName() + "  " + ii);
			if (ii == 20) {
				SecondThread st = new SecondThread(); //区别FirstThread（2）
				// 通过new Thread(target , name)方法创建新线程
				//FirstThread 直接创建对象，就可以用start()方法了，这里更麻烦点
				new Thread(st, "新线程a").start();
				new Thread(st, "新线程b").start();
			}
		}
	}
}
