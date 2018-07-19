package com.ks0100_4;

public class MyThreadTest {

	public static void main(String[] args) {
		
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		
		//以下为匿名内部类的用法
		/*
		Thread t2=new Thread(){
			public void run() {
				for (int x = 0; x < 200; x++) {
					System.out.println(this.getName()+":"+x);
				}
			}
		};
		*/
		//两个线程交替执行任务
		t1.start();//启动第一个线程
		t2.start();//启动第二个线程

	}

}
