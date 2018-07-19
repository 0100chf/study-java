package com.ks0100_3;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/*
 * 虚引用:需要通过java.lang.ref .PhantomReference类来实现。
 * 虚引用完全类似于没有引用。如果一个对象只有一个虚引用时，这个对象和没有引用效果大致相同。
 * 虚引用不能单独使用，必须和引用队列(ReferenceQueue)联合使用，主要用于跟踪对象被垃圾回收的状态。

 */
public class ReferenceTest2 {

	public static void main(String[] args) {
		String s=new String("0100 java培训班");
		//创建一个引用队列，如果被垃圾回收了，对象会放到该队列中去
		ReferenceQueue rq=new ReferenceQueue();
		//创建一个虚引用，引用到字符串
		PhantomReference p=new PhantomReference(s,rq);
		System.out.println(p.get());//null，表示没有引用
		
		//查看引用队列中，有没有虚引用对象
		System.out.println(rq.poll()==p);
		//切断s变量和字符串的引用关系
		s=null;
		System.out.println(p.get());
		//运行gc()方法和 强制系统运行finalize()方法，这样虚引用对象才会被放入队列
		System.gc();
		System.runFinalization();
		//垃圾回收后，虚引用将被放到引用队列中。
		//取出引用队列中最先进入队列的引用与 虚引用对象p比较
		System.out.println(rq.poll()==p);
	}

}
