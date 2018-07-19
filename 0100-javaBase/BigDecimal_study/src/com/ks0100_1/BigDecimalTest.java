package com.ks0100_1;

/*
 * 看程序写结果：结果和我们想的有一点点不一样，这是因为浮点类型的数据存储和整数不一样导致的。它们大部分的时候，都是带有有效数字位。
 * 
 * 由于在运算的时候，float类型和double很容易丢失精度，演示案例。所以，为了能精确的表示、计算浮点数，Java提供了BigDecimal
 * 
 * BigDecimal类：不可变的、任意精度的有符号十进制数,可以解决数据丢失问题。
 */
public class BigDecimalTest {

	public static void main(String[] args) {
		System.out.println("---------用double 类型运算------------");
		System.out.println("0.09 + 0.01="+(0.09 + 0.01));
		System.out.println("1.0 - 0.32="+(1.0 - 0.32));
		System.out.println("1.015 * 100="+(1.015 * 100));
		System.out.println("1.301 / 100="+(1.301 / 100));
		System.out.println("1.011 - 0.12="+(1.011 - 0.12));
		
		System.out.println("---------用float  类型运算------------");
		System.out.println("0.09f + 0.01f="+(0.09f + 0.01f));
		System.out.println("1.0f - 0.32f="+(1.0f - 0.32f));
		 System.out.println("1.015f * 100="+(1.015f * 100));
		 System.out.println("1.301f / 100.0f="+(1.301f / 100.0f));
		 System.out.println("1.011f - 0.12f="+(1.011f - 0.12f));//错误
	}

}
