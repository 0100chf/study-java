package com.ks0100_1;

import java.util.ArrayList;
import java.util.List;

//自己封装一个List，只接受String类型的元素
class StrList{
	private List list=new ArrayList();
	public boolean add(String str){
		return list.add(str);
	}
	public String get(int index){
		return (String)list.get(index);
	}
	public int size(){
		return list.size();
	}
}

public class NoGenericTest2 {
	public static void main(String[] args) {
		StrList strList=new StrList();
		strList.add("0100");
		strList.add("java");
		strList.add("培训");
		//strList.add(123);//不能接受非字符串参数，编译错误
		for(int i=0;i<strList.size();i++){
			String s=strList.get(i);//不需要强制类型转换了
			System.out.println(s);
		}
	}
}
