package com.ks0100_1;

import java.util.Scanner;

public class ScannerDemo2 {

	public static void main(String[] args) {
		// 创建对象
		Scanner sc = new Scanner(System.in);
		// 获取数据
		//hasNextXxx()  判断是否还有下一个输入项,
		//其中Xxx可以是Int,Double等。如果需要判断是否包含下一个字符串，则可以省略Xxx
		if (sc.hasNextInt()) {
			int x = sc.nextInt();
			System.out.println("x:" + x);
		} else  {
			System.out.println("你输入的数据有误");
		}
		if (sc.hasNext()) {
			String s=sc.next();
			System.out.println("你输入的字符串是:" + s);
		} else  {
			System.out.println("你输入的数据有误");
		}
		
	}

}
