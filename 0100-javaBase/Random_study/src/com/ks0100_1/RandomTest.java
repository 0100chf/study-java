package com.ks0100_1;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		
		//Random r = new Random(1111);//种子一样每次生成的都是一样
		Random r = new Random();//没有给种子，用的是默认种子，是当前时间的毫秒值
		for (int x = 0; x < 10; x++) {
			int num = r.nextInt(100);//生成<100的随机数,有参数 返回的是[0,n)范围的内随机数
			//int num = r.nextInt();//返回的是int范围内的随机数
			System.out.println(num);
		}
		
	}

}
