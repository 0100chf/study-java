package com.ks0100.exam.link;

/*
 * 
 * 一个Node对象，表示一个链接点或者节点
 */
public class Node {
	protected Node next; // 引用下一个节点
	protected Object data;// 数据域
	protected Node previous;//引用上一个节点，用在双向链表里
	
	public Node(Object data) {
		this.data = data;
	}

	// 显示此节点,这里只打印整数和字符串类型
	public void display() {
		if (data instanceof String) {
			System.out.print(data + " ");
		}else if( data instanceof Integer){
			System.out.print(data + " ");
		}
		
	}
}
