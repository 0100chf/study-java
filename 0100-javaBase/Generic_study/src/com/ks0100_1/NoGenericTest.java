package com.ks0100_1;

import java.util.ArrayList;
import java.util.List;

public class NoGenericTest {

	public static void main(String[] args) {
		List list=new ArrayList();
		list.add("0100");
		list.add("java");
		list.add("培训");
		list.add(123);//不小心把Integer对象放进集合里
		for(int i=0;i<list.size();i++){
			//List取出的全部都是Object，所以进行类型转换
			//转换到123的时候出现 java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
			String s=(String)list.get(i);
		}
	}

}
