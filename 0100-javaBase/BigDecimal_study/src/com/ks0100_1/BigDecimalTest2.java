package com.ks0100_1;

import java.math.BigDecimal;

public class BigDecimalTest2 {

	public static void main(String[] args) {
		/*
		 * 为了能精确的表示、计算浮点数，Java提供了BigDecimal
		 * BigDecimal类：不可变的、任意精度的有符号十进制数,可以解决数据丢失问题。
		 */
		
		
		 System.out.println("-----用 BigDecimal运算-----------");
		BigDecimal bd1 = new BigDecimal("0.09");
		BigDecimal bd2 = new BigDecimal("0.01");
		System.out.println("0.09+0.01=" + bd1.add(bd2));

		BigDecimal bd3 = new BigDecimal("1.0");
		BigDecimal bd4 = new BigDecimal("0.32");
		System.out.println("1.0-0.32=" + bd3.subtract(bd4));

		BigDecimal bd31 = new BigDecimal("1.011");
		BigDecimal bd41 = new BigDecimal("0.12");
		System.out.println("1.011 - 0.12=" + bd31.subtract(bd41));
		
		
		BigDecimal bd5 = new BigDecimal("1.015");
		BigDecimal bd6 = new BigDecimal("100");
		System.out.println("1.015*100=" + bd5.multiply(bd6));
		System.out.println("-------------------");

		BigDecimal bd7 = new BigDecimal("1.301");
		BigDecimal bd8 = new BigDecimal("100");
		System.out.println("1.301/100=" + bd7.divide(bd8));
		//BigDecimal.ROUND_HALF_UP 四舍五入
		System.out.println("1.301/100= (小数点3位)" + bd7.divide(bd8, 3, BigDecimal.ROUND_HALF_UP));
		System.out.println("1.301/100= (小数点8位)" + bd7.divide(bd8, 8, BigDecimal.ROUND_HALF_UP));
	}

}
