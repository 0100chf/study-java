package com.ks0100_1;

import java.util.Random;

/*
 * 注意在jdk1.7及以下这两种方式产生的随机数序列都有可能重复，
 * 到了jdk1.8 做了修正，不会重复
 */
public class RandomTest2 {

	public static void main(String[] args) {
		//test1();
		 test2();
	}

	
	static void test1() {
		// 1. 为什么随机数会重复？
		for (int x = 0; x < 10000; x++) {
			Random r = new Random();
			int num = r.nextInt(10000);
			System.out.println(num);
		}
	}

	static void test2() {
		// 2. 为什么随机数会重复？
		Random r = new Random();
		for (int x = 0; x < 10000; x++) {
			int num = r.nextInt(10000);
			System.out.println(num);
		}
	}

}
