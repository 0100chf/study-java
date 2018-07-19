package com.ks0100_1;

import java.util.ArrayList;
import java.util.Collections;

public class PokerTest {

	public static void main(String[] args) {
		// 创建一个牌盒
		ArrayList<String> array = new ArrayList<String>();

		// 装牌
		// 黑桃A,黑桃2,黑桃3,...黑桃K
		// 红桃A,...
		// 梅花A,...
		// 方块A,...
		// 定义一个花色数组
		String[] colors = { "♠", "♥", "♣", "♦" };
		// 定义一个点数数组
		String[] numbers = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
		// 装牌
		for (String color : colors) {
			for (String number : numbers) {
				array.add(color.concat(number));//把花色对应数字，组成牌
			}
		}
		array.add("小王");
		array.add("大王");

		// 洗牌
		Collections.shuffle(array);

		// System.out.println("array:" + array);

		// 发牌
		ArrayList<String> ma = new ArrayList<String>();
		ArrayList<String> wang = new ArrayList<String>();
		ArrayList<String> li = new ArrayList<String>();
		ArrayList<String> diPai = new ArrayList<String>();

		for (int x = 0; x < array.size(); x++) {
			if (x >= array.size() - 3) {
				diPai.add(array.get(x));
			} else if (x % 3 == 0) {
				ma.add(array.get(x));
			} else if (x % 3 == 1) {
				wang.add(array.get(x));
			} else if (x % 3 == 2) {
				li.add(array.get(x));
			}
		}

		// 看牌
		lookPoker("马云", ma);
		lookPoker("王健林", wang);
		lookPoker("李嘉诚", li);

		lookPoker("底牌", diPai);
	}

	public static void lookPoker(String name, ArrayList<String> array) {
		System.out.print(name + "的牌是：");
		for (String s : array) {
			System.out.print(s + " ");
		}
		System.out.println();
	}

}
