package com.ks0100_4;

//线程的语法以后讲，这里只是演示一下

public class MyThread extends Thread{
	
	//重写线程的方法
	public void run() {
		for (int x = 0; x < 200; x++) {
			System.out.println(this.getName()+":"+x);
		}
	}
	
}
