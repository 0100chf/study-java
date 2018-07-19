package com.ks0100_4;

import java.util.ArrayList;
import java.util.List;

public class GenericTest4 {

	public static void main(String[] args) {
		//新建一个数组，数组的元素类型是ArrayList类型，很少见吧。
		List<String>[] listArray=new ArrayList[10];
		//新建Object数组，objArray对象和listArray对象都引用一个内存地址
		Object[] objArray=(Object[])listArray;
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(new Integer(3));
		//把一个List<Integer>的元素，加到Object 数组
		objArray[0]=list;
		
		/*
		 * 以下出现类型转换错误
		 * 虽然objArray对象和listArray对象都引用一个内存地址，但是泛型信息，不会自动“复制”过去。
		 */
		//System.out.println(listArray[0].get(0));
		
		Object o=listArray[0].get(0);
		//用instanceof来保证安全
		if(o instanceof String){
			String s=(String)o;
			System.out.println(s);
			
		}
	}

}
