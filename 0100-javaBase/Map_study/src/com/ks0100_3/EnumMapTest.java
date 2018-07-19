package com.ks0100_3;

import java.util.EnumMap;

enum Season{
	Spring,Summer,Autumn,Winter;
}
public class EnumMapTest {

	public static void main(String[] args) {
		EnumMap enumMap=new EnumMap(Season.class);
		enumMap.put(Season.Spring, "春暖花开");
		enumMap.put(Season.Summer, "夏日炎炎");
		//enumMap.put("Spring", "春天");//key 值不能不是枚举项
		System.out.println(enumMap);
	}

}
