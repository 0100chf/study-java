package com.ks0100_1;

import java.math.BigInteger;

public class BigIntegerTest {

	public static void main(String[] args) {
		 System.out.println(Integer.MAX_VALUE);
		 Integer ii = new Integer("2147483647");
		 System.out.println(ii);
		 // NumberFormatException
		 //Integer iii = new Integer("2147483648");
		 //System.out.println(iii);

		// 通过大整数来创建对象
		BigInteger bi = new BigInteger("2147483648");
		System.out.println("bi:" + bi);
		BigInteger bi2 = new BigInteger("2147483648000000");
		System.out.println("bi2:" + bi2);
	}

}
