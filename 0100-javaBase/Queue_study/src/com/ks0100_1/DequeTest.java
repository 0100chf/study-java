package com.ks0100_1;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * 演示队列
 */
public class DequeTest {

	public static void main(String[] args) {
		System.out.println("采用Queue的方法演示队列----------");
		Deque d=new ArrayDeque();
		d.add(10);//offer()方法也是一样
		d.add(2);
		d.add(4);
		d.add(1);
		d.add(4);
		d.add(-6);
		System.out.println("d:"+d);//与先进先出一致
		System.out.println("peek:"+d.peek());
		System.out.println("element:"+d.element());
		System.out.println("d:"+d);
		System.out.print("用 poll 来显示该队列的元素顺序:");
		while(!d.isEmpty()){
			System.out.print(" "+d.poll());//remove()也是一样
		}
		System.out.println();
		System.out.println("d:"+d);
		
		System.out.println("采用Deque的方法演示队列-----------");
		Deque d2=new ArrayDeque();
		d2.addLast(10);//offerLast()方法也是一样
		d2.addLast(2);
		d2.addLast(4);
		d2.addLast(1);
		d2.addLast(4);
		d2.addLast(-6);
		System.out.println("d2:"+d2);//与先进先出一致
		System.out.println("getFirst:"+d2.getFirst());
		System.out.println("peekFirst:"+d2.peekFirst());
		System.out.println("d2:"+d2);
		System.out.print("用 pollFirst 来显示该队列的元素顺序:");
		while(!d2.isEmpty()){
			System.out.print(" "+d2.pollFirst());//removeFirst()也是一样
		}
		System.out.println();
		System.out.println("d2:"+d2);
		
	}

}
