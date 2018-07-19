package com.ks0100_1;

import java.util.Arrays;

public class ArraysTest {

	public static void main(String[] args) {
		// 定义一个数组
		int[] arr = { 24, 69, 80, 57, 13 };

		// public static String toString(int[] a) 把数组转成字符串
		System.out.println("排序前：" + Arrays.toString(arr));

		// public static void sort(int[] a) 对数组进行排序
		Arrays.sort(arr);//经过调优的快速排序法,时间复杂度 n*log(n) 
		System.out.println("排序后：" + Arrays.toString(arr));

		// [13, 24, 57, 69, 80]
		// public static int binarySearch(int[] a,int key) 二分查找
		System.out.println(" 二分法查找  57 在数组中的索引 :" + Arrays.binarySearch(arr, 57));
		System.out.println("二分法查找  577 在数组中的索引 :" + Arrays.binarySearch(arr, 577));//<0，找不到
	}

}
