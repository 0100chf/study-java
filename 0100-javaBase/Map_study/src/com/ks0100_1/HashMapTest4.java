package com.ks0100_1;

import java.util.HashMap;
import java.util.Hashtable;

public class HashMapTest4 {

	public static void main(String[] args) {
		HashMap hm=new HashMap();
		hm.put(null, null);
		hm.put(null, null);
		hm.put("a", null);
		System.out.println(hm);
		
		Hashtable ht=new Hashtable();
		//ht.put(null, null);//key不能为null
		//ht.put("a", null);//value不能为null
		ht.put("a", "b");
		System.out.println(ht);
	}

}
