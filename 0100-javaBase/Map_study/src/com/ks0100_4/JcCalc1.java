package com.ks0100_4;

import java.math.BigInteger;


/*
 * 计算大数阶乘，1*2*3*4*...*i
 */
public class JcCalc1 {

	public static void main(String[] args) {
		long current=System.currentTimeMillis();
		int loop=1300;
		for(int i=1;i<=loop;i++){
			System.out.println(i+":"+calc(BigInteger.valueOf(i)));
		}
		System.out.println("运行第二遍--------------------------");
		for(int i=1;i<=loop;i++){
			System.out.println(i+":"+calc(BigInteger.valueOf(i)));
		}
		System.out.println("运行了:"+(System.currentTimeMillis()-current)+"毫秒");
		
		
	}
	
	private static BigInteger calc(BigInteger i){
		//0的阶乘是1
		if(i.compareTo(BigInteger.valueOf(0))==0){
			return BigInteger.valueOf(1);
		}else{
			//subtract是减法 a=i-1
			BigInteger a=i.subtract(BigInteger.valueOf(1));
			//递归,1*2*3*4...*i
			return calc(a).multiply(i);
		}
	}

}
