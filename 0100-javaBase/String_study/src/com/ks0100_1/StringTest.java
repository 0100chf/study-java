package com.ks0100_1;

public class StringTest {

	public static void main(String[] args) {
	
		String s1 = "hello";
		
		String s2 = new String("hello");
		if(s1==s2){
			System.out.println("s1和s2 是同一个对象，内存地址相等");
		}else{
			System.out.println("s1和s2 不是一个对象");
		}
		
		
		String s3 = "hello";
		s3 += "world";
		System.out.println("s3="+s3);
		if(s3=="helloworld"){
			System.out.println("s3和\"helloworld\" 是同一个对象，内存地址相等");
		}else{
			System.out.println("s3和\"helloworld\" 不是一个对象");
		}
		
		System.out.println("helloworld 地址标识："+System.identityHashCode("helloworld"));
		System.out.println("s3="+s3+"变量地址标识："+System.identityHashCode(s3));
		

		
		
	}

}
