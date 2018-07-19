package com.ks0100_3;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class IdentityHashMapTest {

	public static void main(String[] args) {
		hashMap_func();
		identityHashMap_func();
	}
	
	public static void hashMap_func(){
		HashMap i=new HashMap();
		//以下语文的key，不是一个对象
		i.put(new String("语文"), 100);
		i.put(new String("语文"), 66);
		//以下数学的key,是一个对象
		i.put("数学", 99);
		i.put("数学", 70);
		System.out.println(i);
	}
	
	public static void identityHashMap_func(){
		IdentityHashMap i=new IdentityHashMap();
		//以下语文的key，不是一个对象
		i.put(new String("语文"), 100);
		i.put(new String("语文"), 66);
		//以下数学的key,是一个对象
		i.put("数学", 99);
		i.put("数学", 70);
		System.out.println(i);
	}

}
