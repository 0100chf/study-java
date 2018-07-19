package com.ks0100_3;

import java.lang.ref.WeakReference;

/*
 * 弱引用:需要通过java.lang.ref .WeakReference 类来实现。
 * 弱引用比软引用级别低，不管系统内存是否足够，总会gc该对象。但不是用完对象后，就立即被gc，而是要运行系统的垃圾回收机制才会被gc。所以弱引用，使用效果更明显。

 */
public class ReferenceTest {

	public static void main(String[] args) {
		String s=new String("0100 java培训班");
		//String s="0100 java培训班";//就不行，因为是直接引用字符串常量，弱引用不起作用
		//创建一个弱引用，引用对象为字符串
		WeakReference wr=new WeakReference(s);
		//切断s变量和字符串的引用关系
		s=null;
		//取出弱引用对象
		System.out.println(wr.get());
		//强制垃圾回收后,弱引用为null
		System.gc();
		//System.runFinalization();//如果gc没作用，强制系统运行finalize()方法
		System.out.println(wr.get());
	}

}
