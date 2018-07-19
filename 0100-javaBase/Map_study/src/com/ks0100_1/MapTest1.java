package com.ks0100_1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest1 {

	public static void main(String[] args) {
		// 创建集合对象
		Map<String, String> map = new HashMap<String, String>();

		// 添加元素
		// V put(K key,V value):添加元素
		System.out.println("put 元素，男士做key，女士做value--------");
		map.put("邓超", "孙俪");
		map.put("黄晓明", "杨颖");
		map.put("周杰伦", "昆凌");
		map.put("刘恺威", "杨幂");
		map.put("文章", "马伊俐");
		map.put("文章", "姚笛");// 后面put的，会把前面的value覆盖掉。
		System.out.println("map:" + map);
		// V remove(Object key)：根据键删除键值对元素，并把值返回
		System.out.println("remove:" + map.remove("黄晓明"));
		System.out.println("remove:" + map.remove("黄晓波"));
		System.out.println("remove 后map:" + map);

		// boolean containsKey(Object key)：判断集合是否包含指定的键
		System.out.println("containsKey 黄晓明:" + map.containsKey("黄晓明"));
		// int size()：返回集合中的键值对的对数
		System.out.println("size:" + map.size());

		// V get(Object key):根据键获取值
		System.out.println("get 周杰伦:" + map.get("周杰伦"));
		System.out.println("get 周杰:" + map.get("周杰")); // 返回null

		System.out.println("-------获取集合中所有key(键)的集合");
		// Set<K> keySet():获取集合中所有键的集合
		Set<String> set = map.keySet();
		for (String key : set) {
			System.out.println(key);
		}
		System.out.println("---------获取集合中所有value(值)的集合");
		// Collection<V> values():获取集合中所有值的集合
		Collection<String> con = map.values();
		for (String value : con) {
			System.out.println(value);
		}
		System.out.println("---------通过key的遍历来获取value(值)的集合");
		for (String key : set) {
			System.out.println(key + ":" + map.get(key));
		}
		
		System.out.println("---------通过entrySet()来获取 key value的集合");
		// 获取所有键值对对象的集合
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		// 遍历键值对对象的集合，得到每一个键值对对象
		for (Map.Entry<String, String> me : entrySet) {
			// 根据键值对对象获取键和值
			String key = me.getKey();
			String value = me.getValue();
			System.out.println(key + "---" + value);
		}

		// void clear():移除所有的键值对元素
		map.clear();

		// boolean isEmpty()：判断集合是否为空
		System.out.println("isEmpty:" + map.isEmpty());

		// 输出集合名称
		System.out.println("map:" + map);
	}

}
