package com.ks0100_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FinallyTest {

	public static void main(String[] args) {
		//以下两个方法分别打开注释执行
		test1();
		//System.out.println(getInt());
	}

	static void test1() {
		String s = "2014-11-20";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date d = null;
		try {
			d = sdf.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			System.out.println("这里的代码是可以执行的");// 前面有System.exit(0);，就不能执行了
		}

		System.out.println(d);
	}

	static int getInt() {
		int a = 10;
		try {
			System.out.println(a / 0);
			a = 20;
		} catch (ArithmeticException e) {
			a = 30;
			return a;
			/*
			 * return a在程序执行到这一步的时候，这里不是return a而是return 30;这个返回路径就形成了。
			 * 但是呢，它发现后面还有finally，所以继续执行finally的内容，a=40 再次回到以前的返回路径，继续走return
			 * 30;
			 */
		} finally {
			a = 40;
			return a;// 如果这样结果就是40了。
		}
		// return a;
	}

}
