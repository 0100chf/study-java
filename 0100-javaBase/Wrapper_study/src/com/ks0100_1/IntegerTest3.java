package com.ks0100_1;


public class IntegerTest3 {

	public static void main(String[] args) {
		Integer i1 = new Integer(127);
		Integer i2 = new Integer(127);
		System.out.println(i1 == i2);
		System.out.println("1-----------------");
		Integer i3 = new Integer(128);
		Integer i4 = new Integer(128);
		System.out.println(i3 == i4);
		System.out.println("2-----------------");
		Integer i5 = 127;
		Integer i6 = 127;//i5 ,i6 都引用 127
		System.out.println(i5 == i6);
		System.out.println("3-----------------");
		Integer i7 = 128;
		Integer i8 = 128;//自动装箱 Integer valueOf()
		System.out.println(i7 == i8);//false 奇怪吧
		/*
		 * 查看源码
		 *     
			 public static Integer valueOf(int i) {
	        	if(i >= -128 && i <= IntegerCache.high)
	            		return IntegerCache.cache[i + 128];
	        	else
	            		return new Integer(i);
	    	}
	    	i=128，IntegerCache.high为127 所以return new Integer(128);
		 */

	}

}
