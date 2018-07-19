package com.ks0100_1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
 * 演示栈
 */
public class DequeTest2 {

	public static void main(String[] args) {
		System.out.println("用Stack来演示栈------------");
		Stack s=new Stack();
		s.push(10);
		s.push(2);
		s.push(4);
		s.push(1);
		s.push(4);
		s.push(-6);
		System.out.println("s:"+s);//显示的是Collection的顺序，不是先进后出
		System.out.println("peek:"+s.peek());
		System.out.println("s:"+s);
		System.out.print("用 pop 来显示该Stack的元素顺序:");
		while(!s.isEmpty()){
			System.out.print(" "+s.pop());
		}
		System.out.println();
		System.out.println("s:"+s);
		System.out.println("用Deque来演示栈------------");
		Deque d=new ArrayDeque();
		d.addFirst(10);//offerFirst()方法也是一样
		d.addFirst(2);
		d.addFirst(4);
		d.addFirst(1);
		d.addFirst(4);
		d.addFirst(-6);
		System.out.println("d:"+d);//与先进后出一致
		System.out.println("getFirst:"+d.getFirst());
		System.out.println("peekFirst:"+d.peekFirst());
		System.out.println("d:"+d);
		System.out.print("用 removeFirst 来显示该队列的元素顺序:");
		while(!d.isEmpty()){
			System.out.print(" "+d.removeFirst());//pollFirst()也是一样
		}
		System.out.println();
		System.out.println("d:"+d);
	}

}
