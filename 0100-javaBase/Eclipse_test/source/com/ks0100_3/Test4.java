package com.ks0100_3;

//Fibonacci数列
public class Test4 {
	public static void main(String[] args) {
		int a = 0, b = 1;
		while (b < 100) {
			System.out.print(" "+b);
			int temp = a;
			a = b;
			b = temp + b;
		}
	}
}
