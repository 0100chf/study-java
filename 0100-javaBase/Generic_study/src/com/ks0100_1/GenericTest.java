package com.ks0100_1;

import java.util.ArrayList;
import java.util.List;

//大家看，黄色警告都没有了。
public class GenericTest {

	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("0100");
		list.add("java");
		list.add("培训");
		//list.add(123);//不能接受非字符串参数，编译错误,因为泛型强制元素类型是String类
		for(int i=0;i<list.size();i++){
			String s=list.get(i);//不需要强制类型转换了
			System.out.println(s);
		}
	}

}
