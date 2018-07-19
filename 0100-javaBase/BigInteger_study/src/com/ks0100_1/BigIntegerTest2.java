package com.ks0100_1;

import java.math.BigInteger;

public class BigIntegerTest2 {

	public static void main(String[] args) {
		BigInteger bi1 = new BigInteger("2147483648000000");
		BigInteger bi2 = new BigInteger("2");

		// public BigInteger add(BigInteger val):加
		System.out.println("2147483648000000+2=" + bi1.add(bi2));
		// public BigInteger subtract(BigInteger val):减
		System.out.println("2147483648000000-2=" + bi1.subtract(bi2));
		// public BigInteger multiply(BigInteger val):乘
		System.out.println("2147483648000000*2=" + bi1.multiply(bi2));
		// public BigInteger divide(BigInteger val):除
		System.out.println("2147483648000000/2=" + bi1.divide(bi2));

		// public BigInteger[] divideAndRemainder(BigInteger val):返回商和余数的数组
		BigInteger bi3 = new BigInteger("2147483648000000");
		BigInteger bi4 = new BigInteger("3");
		
		BigInteger[] bis = bi3.divideAndRemainder(bi4);
		System.out.println("2147483648000000/3的商=" + bis[0]);
		System.out.println("2147483648000000/3 的余数=" + bis[1]);
		
	}

}
