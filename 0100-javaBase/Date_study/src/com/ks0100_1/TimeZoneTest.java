package com.ks0100_1;

import java.util.Arrays;
import java.util.TimeZone;

public class TimeZoneTest {

	public static void main(String[] args) {
		String[] ids=TimeZone.getAvailableIDs();
		System.out.println("打印所有时区id：");
		System.out.println(Arrays.toString(ids));//Arrays类的方法，把数组元素转换为字符串
		System.out.println("获取系统默认时区：");
		TimeZone my=TimeZone.getDefault();
		System.out.println(my.getID());//参考时区id
		System.out.println(my.getDisplayName());
		System.out.println(TimeZone.getTimeZone("CNT").getDisplayName());//参考时区id
	}

}
