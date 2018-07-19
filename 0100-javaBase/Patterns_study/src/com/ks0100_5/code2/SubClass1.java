package com.ks0100_5.code2;

//番茄炒蛋的做法
public class SubClass1 extends Template{

	@Override
	protected void clean() {
		System.out.println("洗好番茄");
	}

	@Override
	protected void cut() {
		System.out.println("切番茄");
		System.out.println("搅拌鸡蛋");
	}

	@Override
	protected void cook() {
		System.out.println("菜油热锅");
		System.out.println("下鸡蛋");
		System.out.println("炒鸡蛋");
		System.out.println("下番茄");
		System.out.println("鸡蛋和番茄一起炒");
		System.out.println("煮几分钟");
		System.out.println("起锅，放调料");
	}



}
