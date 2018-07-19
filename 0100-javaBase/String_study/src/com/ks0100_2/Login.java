package com.ks0100_2;

import java.util.Scanner;

/*
 * 模拟登录,给三次机会,并提示还有几次。如果登录成功，就可以玩猜数字小游戏了。
 * 
 * 分析：
 * 		A:定义用户名和密码。已存在的。
 * 		B:键盘录入用户名和密码。
 * 		C:比较用户名和密码。
 * 			如果都相同，则登录成功
 * 			如果有一个不同，则登录失败
 * 		D:给三次机会，用循环改进，最好用for循环。
 */
public class Login {
	public static void main(String[] args) {
		// 定义用户名和密码。已存在的。
		String username = "ks0100";
		String password = "ks0100";

		// 给三次机会，用循环改进，最好用for循环。
		for (int x = 1; x <= 3; x++) {
			// 键盘录入用户名和密码。
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入用户名：");
			String name = sc.nextLine();
			System.out.println("请输入密码：");
			String pwd = sc.nextLine();

			// 比较用户名和密码。
			if (name.equals(username) && pwd.equals(password)) {
				// 如果都相同，则登录成功
				System.out.println("登录成功,开始玩游戏");
				// 猜数字游戏
				GuessNumberGame.start();
				break;
			} else {
				// 如果是第0次，则锁定
				if ((3 - x) == 0) {
					System.out.println("帐号被锁定，请和管理员练习");
				} else {
					System.out.println("登录失败，你还有" + (3 - x) + "次机会");
				}
			}
		}
	}
}
