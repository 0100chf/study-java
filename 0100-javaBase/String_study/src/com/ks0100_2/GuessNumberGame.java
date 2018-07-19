package com.ks0100_2;

import java.util.Scanner;

public class GuessNumberGame {
	private GuessNumberGame() {
	}

	public static void start() {
		// 产生一个随机数,随机数以后会讲
		int number = (int) (Math.random() * 100) + 1;
		//写一个死循环
		while (true) {
			// 键盘录入数据
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入你要猜的数据(1-100)，输入exit退出游戏:");
			//为了程序健壮，判断输入的是不是整数
			if(sc.hasNextInt()){
				int guessNumber = sc.nextInt();
				// 判断
				if (guessNumber > number) {
					System.out.println("你猜的数据" + guessNumber + "大了");
				} else if (guessNumber < number) {
					System.out.println("你猜的数据" + guessNumber + "小了");
				} else {
					System.out.println("恭喜你，猜中了");
					break;
				}
		
			}else{
				//当输入exit退出循环
				String exit=sc.next();
				if(exit.contains("exit")){
					break;
				}else{
					System.out.println("你输入有误请继续。");
				}
			}

			
		}
	}
}
