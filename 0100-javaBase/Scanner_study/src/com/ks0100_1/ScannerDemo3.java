package com.ks0100_1;

import java.util.Scanner;

/*
 * 这个例子是教大家区别
 * Scanner 的方法nextInt()、nextLine()、next()的用法区别
 */
public class ScannerDemo3 {

	public static void main(String[] args) {
		// 创建对象
		Scanner sc = new Scanner(System.in);

		//以下代码依次打开方法注释，一次只能运行一个方法	
//		func1(sc);
//		func2(sc);
//		func3(sc);
//		func4(sc);
		func5(sc);
	}
	
	static void func1(Scanner sc ){
		// 获取两个int类型的值
		 System.out.println("输入两个整数,可以用回车，Tab，空格来分隔:");
		 int a = sc.nextInt();
		 int b = sc.nextInt();
		 System.out.println("a:" + a + ",b:" + b);
		 System.out.println("-------------------");
	}

	static void func2(Scanner sc ){
		// 获取两个String类型的值
		 System.out.println("输入两个字符串,可以用回车来分隔:");
		 String s1 = sc.nextLine();
		 String s2 = sc.nextLine();
		 System.out.println("s1:" + s1 + ",s2:" + s2);
		 System.out.println("-------------------");
	}
	
	static void func3(Scanner sc ){
		
		// 先获取一个字符串，再获取一个int值
		 System.out.println("输入一个字符串，用回车分隔：");
		 String s1 = sc.nextLine();//用回车分隔
		 System.out.println("输入一个字符串，用回车，Tab，空格来分隔：");
		 String s2 = sc.next();//用回车，Tab，空格来分隔
		 System.out.println("输入一个整数，用回车，Tab，空格来分隔：");
		 int i = sc.nextInt();
		 System.out.println("s1:" + s1 + ",s2:"+s2+",i:" + i);
		 System.out.println("-------------------");
	}
	
	static void func4(Scanner sc ){
		System.out.println("请随意输入，按回车会打印结果，如果输入exit则退出程序:");
		String s=null;
		while(sc.hasNext()){
			s=sc.nextLine();
			if(s.equals("exit")){
				return;
			}
			System.out.println("键盘输入的内容是:"+s);
		}
	}
	
	//这个例子只是为了举例useDelimiter()的方法
	static void func5(Scanner sc ){
		System.out.println("请随意输入，按回车会打印结果，如果输入exit则退出程序:");
		sc.useDelimiter("\n");//只把回车作为分隔符
		String s=null;
		while(sc.hasNext()){
			s=sc.next();
//			if(s.contains("exit")){ //字符串的方法，s字符串是否包含"exit"
			if(s.equals("exit")){ //不能这样判断，s结尾包含回车	
				System.exit(0);//退出程序
			}
			System.out.println("键盘输入的内容是:"+s);
		}
	}
	
}
