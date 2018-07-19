package com.ks0100_2;

public class PassByValue {
	static void swap(int n1, int n2) {
		int tmp = n1;n1 = n2;
		n2 = tmp;
		System.out.println("进入swap方法，交换后，num1和num2的值为：" + n1 + "," + n2);
	}
	public static void main(String[] args) {
		int num1 = 1;int num2 = 2;
		swap(num1, num2);
		System.out.println("调用swap方法后，num1和num2的值为：" + num1 + "," + num2);
	}
}
