package com.ks0100_3;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;

enum Season{
	Spring,Summer,Autumn,Winter
}
public class EnumSet1 {

	public static void main(String[] args) {
		//之前学习的遍历枚举项的方法
		Season[] season=Season.values();
		for(Season s:season){
			System.out.println(s);
		}
		System.out.println("1------");
		for(int i=0;i<season.length;i++){
			System.out.println(season[i]);
		}
		System.out.println("2------");
		/*
		 * EnumSet 类没有暴露任何构造器来创建该类的实例。
		 * 通过常用的static方法来创建EnumSet对象
		 */
		//创建一个EnumSet集合，集合元素就是Season枚举类的全部枚举值
		EnumSet e=EnumSet.allOf(Season.class);
		System.out.println("e:"+e);
		//创建一个EnumSe空t集合，指定其集合元素的类型是Season类的枚举值
		EnumSet e2=EnumSet.noneOf(Season.class);
		System.out.println("e2:"+e2);
		e2.add(Season.Winter);
		e2.add(Season.Autumn);
		e2.add(Season.Summer);
		e2.add(Season.Winter);
		//类似栈排序，先加入的排后面，元素唯一
		System.out.println("e2:"+e2);
		//以指定枚举值创建EnumSet集合
		EnumSet e3=EnumSet.of(Season.Summer,Season.Winter);
		System.out.println("e3:"+e3);
		EnumSet e4=EnumSet.range(Season.Spring, Season.Autumn);
		System.out.println("e4:"+e4);
		
		//e5集合元素  = Season 的全部枚举值 -e4集合元素
		EnumSet e5=EnumSet.complementOf(e4);
		System.out.println("e5:"+e5);
		
		System.out.println("以下测试 复制---------------");
		Collection c=new HashSet();
		c.add(Season.Autumn);
		c.add(Season.Spring);
		EnumSet e6=EnumSet.copyOf(c);
		System.out.println("e6:"+e6);
		
		c.add("Winter");
		//e6=EnumSet.copyOf(c);//出现异常，不允许非枚举类型的元素
	}

}
