package com.ks0100_4;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack s=new Stack();
		s.push("111");
		s.push("222");
		s.push("333");
		System.out.println("s:"+s);
		System.out.println("peek:"+s.peek());
		System.out.println("peek 只是查看首元素，不会弹栈  s:"+s);
		System.out.println("pop:"+s.pop());
		System.out.println("pop 后弹栈  s:"+s);
	}

}
