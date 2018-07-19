package com.ks0100_2;

import java.util.HashMap;
import java.util.Set;
//HashMap嵌套HashMap
public class HashMapIncludeHashMap {

	public static void main(String[] args) {
		// 创建集合对象,value是HashMap,
		HashMap<String, HashMap<String, Integer>> baseMap = new HashMap<String, HashMap<String, Integer>>();

		// 创建三国演义集合对象
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		// 添加元素
		map1.put("吕布", 99);//value的Integer，代表武力值
		map1.put("关羽", 97);
		// 把基础班添加到大集合
		baseMap.put("三国演义", map1);

		// 创建笑傲江湖集合对象
		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
		// 添加元素
		map2.put("令狐冲", 201);
		map2.put("林平之", 130);
		// 把基础班添加到大集合
		baseMap.put("笑傲江湖", map2);

		// 遍历集合
		Set<String> baseMapSet = baseMap.keySet();
		//遍历外层map
		for (String baseMapKey : baseMapSet) {
			System.out.println(baseMapKey);
			HashMap<String, Integer> baseMapValue = baseMap.get(baseMapKey);
			//遍历内层map
			Set<String> baseMapValueSet = baseMapValue.keySet();
			for (String baseMapValueKey : baseMapValueSet) {
				Integer baseMapValueValue = baseMapValue.get(baseMapValueKey);
				System.out.println("\t" + baseMapValueKey + "---" + baseMapValueValue);
			}
		}
	}

}
