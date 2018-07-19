package com.ks0100_1;

import java.util.Scanner;

/*
 * try...catch...finally的处理格式：
 * 
 * 		try {
 * 			可能出现问题的代码;
 * 		}catch(异常名1 变量) {
 * 			针对问题1的处理;
 * 		}catch(异常名2 变量) {
 * 			针对问题2的处理;
 * 		}finally {
 * 			释放资源;不管有没有异常都会执行这一步。
 * 		}
 */
public class ExceptionTest2 {
	
	public static void main(String[] args) {
		System.out.println("请输入两个数字，求除法运算:");
		int[] i = setIntArray();
		
		try {
			System.out.println(i[0] + "除以" + i[1] + "=" + (i[0] / i[1]));
		}catch (ArithmeticException ae) {
			System.out.println("算术异常");
		} catch (Exception e) {
			System.out.println("未知异常");
		}
		finally{
			System.out.println("做完算术，系统自动关闭。。");
		}
	}
	
	//通过补捉异常，让程序继续执行
	public static int[] setIntArray(){
		int[] i = new int[2];
		Scanner s = new Scanner(System.in);
		try {
			System.out.print("第一个数字:");
			i[0] = Integer.parseInt(s.nextLine());
			System.out.print("第二个数字:");
			i[1] = Integer.parseInt(s.nextLine());

		} catch (NumberFormatException ne) {
			System.out.println("输入格式异常：只能接受整数参数");
			return setIntArray();//用递归让程序继续执行
		}  catch (Exception e) {
			System.out.println("未知异常");
			return setIntArray();//用递归让程序继续执行
		}
		return i;
	}
	
	
	
}
