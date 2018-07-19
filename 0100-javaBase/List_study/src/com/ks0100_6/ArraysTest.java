package com.ks0100_6;

import java.util.Arrays;
import java.util.List;

public class ArraysTest {

	public static void main(String[] args) {
		List fixedList=Arrays.asList("111","222","333");
		System.out.println("fixedList:"+fixedList.getClass());
		//以下代码 会引起异常  java.lang.UnsupportedOperationException
		//fixedList.add("444");
		//fixedList.remove("111");
	}

}
