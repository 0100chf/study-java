package com.ks0100_1;

import java.util.HashMap;
import java.util.Set;

public class HashMapTest {
	public static void main(String[] args) {
		// 创建集合对象
		HashMap<Object, String> hm = new HashMap<Object, String>();//这里key是Object对象，如果把key定义成String，那么key只能为String对象了，Integer同理
		//前一个参数是key，后一个参数是value
		hm.put("it001", "马云");
		hm.put("it003", "马化腾");
		hm.put("it004", "乔布斯");
		hm.put("it005", "张朝阳");
		hm.put("it002", "裘伯君"); // wps
		hm.put("it001", "比尔盖茨");
		hm.put(27, "林青霞");
		hm.put(30, "风清扬");
		hm.put(28, "刘意");
		hm.put(29, "林青霞");

		// 下面的写法是八进制，但是不能出现8以上的单个数据
		hm.put(003, "hello");
		hm.put(006, "hello");
		hm.put(007, "hello");
		// hm.put(008, "hello");
		// 遍历
		Set set = hm.keySet();
		for (Object key : set) {
			String value = hm.get(key);
			System.out.println(key + "---" + value);
		}
		// 下面这种方式仅仅是集合的元素的字符串表示
		System.out.println("hm:" + hm);
	}

}
