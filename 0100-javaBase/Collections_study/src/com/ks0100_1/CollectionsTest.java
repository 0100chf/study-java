package com.ks0100_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

	public static void main(String[] args) {
		// 创建集合对象
		List<Integer> list = new ArrayList<Integer>();

		// 添加元素
		list.add(30);
		list.add(20);
		list.add(50);
		list.add(10);
		list.add(40);
		list.add(30);
		
		System.out.println("list:" + list);

		// public static <T> void sort(List<T> list)：排序 默认情况下是自然顺序。
		System.out.println("开始排序:");
		Collections.sort(list);
		System.out.println("list:" + list);

		// public static <T> int binarySearch(List<?> list,T key):二分查找
		System.out.println("binarySearch 30:" + Collections.binarySearch(list, 30));
		System.out.println("binarySearch 300:" + Collections.binarySearch(list, 300));

		// public static <T> T max(Collection<?> coll):最大值
		System.out.println("max:" + Collections.max(list));
		//public static <T>  T min(Collection<?> coll) :最小值
		System.out.println("min:" + Collections.min(list));
		//判断30 在集合中出现的次数
		System.out.println("30 出现的次数:"+Collections.frequency(list, 30));
		
		// public static void reverse(List<?> list):反转
		Collections.reverse(list);
		System.out.println("反转 list:" + list);

		// public static void shuffle(List<?> list):随机置换
		Collections.shuffle(list);
		System.out.println("随机 list，类似洗牌:" + list);//每次运行都不一样
	}

}
