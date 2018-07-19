package com.ks0100_1;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsTest3 {

	public static void main(String[] args) {
		List list=Collections.emptyList();
		//list.add("0100"); //只读，不能加元素,java.lang.UnsupportedOperationException
		Set set=Collections.singleton("0100java");
		//set.add("培训班");//只读，不能加元素,java.lang.UnsupportedOperationException
		Map map=new HashMap();
		map.put("语文", 100);
		map.put("数学", 70);
		Map m=Collections.unmodifiableMap(map);
		//m.put("java", 100);//只读，不能加元素,java.lang.UnsupportedOperationException
	}

}
