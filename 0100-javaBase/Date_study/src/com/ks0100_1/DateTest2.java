package com.ks0100_1;

import java.util.Calendar;

public class DateTest2 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
	}

	public static void test1() {
		System.out.println("-------test1------------");
		// 其日历字段已由当前日期和时间初始化：
		Calendar rightNow = Calendar.getInstance(); // 子类对象
		// 获取年
		int year = rightNow.get(Calendar.YEAR);
		// 获取月
		int month = rightNow.get(Calendar.MONTH);// 1月从0开始
		// 获取日
		int date = rightNow.get(Calendar.DATE);
		System.out.println(year + "年" + (month + 1) + "月" + date + "日");
	}

	public static void test2() {
		System.out.println("-------test2------------");
		// 获取当前的日历时间
		Calendar c = Calendar.getInstance();

		// 获取年
		int year = c.get(Calendar.YEAR);
		// 获取月
		int month = c.get(Calendar.MONTH);
		// 获取日
		int date = c.get(Calendar.DATE);
		System.out.println("现在日期:"+year + "年" + (month + 1) + "月" + date + "日");

		 // 三年前的今天
		 c.add(Calendar.YEAR, -3);
		 // 获取年
		 year = c.get(Calendar.YEAR);
		 // 获取月
		 month = c.get(Calendar.MONTH);
		 // 获取日
		 date = c.get(Calendar.DATE);
		 System.out.println("三年前的今天:"+year + "年" + (month + 1) + "月" + date + "日");

		// 5年后的10天前
		// 获取当前的日历时间
		Calendar c2 = Calendar.getInstance();
		c2.add(Calendar.YEAR, 5);
		c2.add(Calendar.DATE, -10);//可以减
		// 获取年
		year = c2.get(Calendar.YEAR);
		// 获取月
		month = c2.get(Calendar.MONTH);
		// 获取日
		date = c2.get(Calendar.DATE);
		System.out.println("5年后的10天前:"+year + "年" + (month + 1) + "月" + date + "日");
		System.out.println("--------------");

		// 获取当前的日历时间
		Calendar c3 = Calendar.getInstance();
		System.out.println("设置时间为2011年11月11日");
		c3.set(2011, 10, 11);//月份要减1表示
		// 获取年
		year = c3.get(Calendar.YEAR);
		// 获取月
		month = c3.get(Calendar.MONTH);
		// 获取日
		date = c3.get(Calendar.DATE);
		System.out.println(year + "年" + (month + 1) + "月" + date + "日");
	}
	
	public static void test3() {
		System.out.println("-------test3------------");
		Calendar c = Calendar.getInstance();
		c.set(2016, 1, 31);//2016年2月31日,只有2016年2月29日，自动累加到3月2日
		System.out.println(c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月" + c.get(Calendar.DATE) + "日");
	}
	
	public static void test4() {
		System.out.println("-------test4------------");
		Calendar c = Calendar.getInstance();
		c.set(2015, 11, 30);
		System.out.println(c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月" + c.get(Calendar.DATE) + "日");
		c.add(Calendar.MONTH, 1);
		System.out.println("用add 加1月:");
		System.out.println(c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH) + 1) + "月" + c.get(Calendar.DATE) + "日");
		Calendar c2 = Calendar.getInstance();
		c2.set(2015, 11, 30);
		c2.roll(Calendar.MONTH, 1);
		System.out.println("用roll 加1月:");
		System.out.println(c2.get(Calendar.YEAR) + "年" + (c2.get(Calendar.MONTH) + 1) + "月" + c2.get(Calendar.DATE) + "日");
	}
	public static void test5() {
		System.out.println("-------test5------------");
		Calendar c = Calendar.getInstance();
		System.out.println("设置月份为13");
		c.set(Calendar.MONTH, 13);//会自动累加
		System.out.println(c.getTime());
		c.setLenient(false);//关闭容错性
		//c.set(Calendar.MONTH, 13);//不会自动累加，报错了
	}
}
