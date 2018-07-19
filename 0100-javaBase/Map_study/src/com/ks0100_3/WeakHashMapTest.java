package com.ks0100_3;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapTest {

	public static void main(String[] args) {
		hashMap_func();
		System.out.println("--------");
		weakHashMap();
	}
	
	public static void hashMap_func(){
		HashMap h=new HashMap();
		//以下三个key都是匿名字符串对象，没有其他引用
		h.put(new String("语文"), new String("良好"));
		h.put(new String("数学"), new String("优秀"));
		h.put(new String("英语"), new String("及格"));
		//以下两个key都是常量字符串
		h.put("历史", new String("中等"));
		h.put("地理", "优秀");
		//再来一个key是匿名字符串对象，value是常量字符串的
		h.put(new String("体育"), "优秀");
		//key是被其他变量强引用的
		String key1=new String("生物");
		h.put(key1, "及格");
		System.out.println(h);
		System.gc();
		System.runFinalization();
		System.out.println(h);
		
		//切断'生物'key的强引用关系
		key1=null;
		System.gc();
		System.runFinalization();
		System.out.println(h);
	}
	
	public static void weakHashMap(){
		WeakHashMap w=new WeakHashMap();
		//以下三个key都是匿名字符串对象，没有其他引用
		w.put(new String("语文"), new String("良好"));
		w.put(new String("数学"), new String("优秀"));
		w.put(new String("英语"), new String("及格"));
		//以下两个key都是常量字符串
		w.put("历史", new String("中等"));
		w.put("地理", "优秀");
		//再来一个key是匿名字符串对象，value是常量字符串的
		w.put(new String("体育"), "优秀");
		//key是被其他变量强引用的
		String key1=new String("生物");
		w.put(key1, "及格");
		System.out.println(w);
		System.gc();
		System.runFinalization();
		System.out.println(w);
		
		//切断'生物'key的强引用关系
		key1=null;
		System.gc();
		System.runFinalization();
		System.out.println(w);
	}

}
