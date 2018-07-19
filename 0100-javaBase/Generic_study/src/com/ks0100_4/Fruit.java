package com.ks0100_4;

import java.util.ArrayList;
import java.util.List;

//T 是在类上面定义的泛型类
public class Fruit<T> {
	
	//private static T info2;//错误，不能在静态Field声明使用在类上面定义的泛型类型形参
	//static void setInfo2(T info2){}//错误，不能在静态方法声明使用在类上面定义的泛型类型形参
	private T info;//在成员变量上使用在类上面定义的泛型T
	
	public Fruit(T info){//在方法上使用在类上面定义的泛型T
		this.info=info;
	}
	public T getInfo() {
		return info;
	}
	
	public void setInfo(T info) {
		this.info = info;
	}
	
	//T2 是在方法上定义的泛型，可以用静态方法
	//这个方法是把数组的元素，加到list里面去
	public static  <T2> void fromArrayToList(T2[] array,List<T2> list){
		for(T2 element:array){
			list.add(element);
		}
	}
	//T2 是在方法上定义的泛型，也可以用非静态方法
	public   <T2> void fromArrayToList2(T2[] array,List<T2> list){
		for(T2 element:array){
			list.add(element);
		}
	}
	
	public static void main(String[] args) {
		Object[] oarray=new Object[100];
		List<Object> list1=new ArrayList<Object>();
		fromArrayToList(oarray,list1);//可以接受List<Object>参数
		String[] sarray=new String[100];
		List<String> list2=new ArrayList<String>();
		
		fromArrayToList(sarray,list2);//可以接受List<String>参数
		Integer[] ia=new Integer[100];
		Float[] fa=new Float[100];
		Number[] na=new  Number[100];
		
		List<Number> list3=new ArrayList<Number>();
		fromArrayToList(ia,list3);
		fromArrayToList(fa,list3);
		fromArrayToList(na,list3);
		//T2代表Object，Number[] na形参可以转 Object[] array实参
		fromArrayToList(na,list1);
		
		//fromArrayToList(na,list2);//编译错误，T2代表String，Number[] na形参不能转 String[] array实参
	}
}











