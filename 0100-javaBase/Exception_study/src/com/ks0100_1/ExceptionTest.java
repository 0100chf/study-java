package com.ks0100_1;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		System.out.println("请输入两个数字，求除法运算:");
		Scanner s = new Scanner(System.in);
		int[] i = new int[2];
		
		try {
			System.out.print("第一个数字:");
			i[0] = Integer.parseInt(s.nextLine());
			System.out.print("第二个数字:");
			i[1] = Integer.parseInt(s.nextLine());

			System.out.println(i[0] + "除以" + i[1] + "=" + (i[0] / i[1]));
			//出现异常怎样让程序继续执行，看ExceptionTest2
		} catch (NumberFormatException ne) {
			System.out.println("输入格式异常：只能接受整数参数");
		} catch (ArithmeticException ae) {
			System.out.println("算术异常");
		} catch (Exception e) {
			System.out.println("未知异常");
		}
	}

}
