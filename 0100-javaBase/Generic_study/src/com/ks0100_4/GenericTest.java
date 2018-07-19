package com.ks0100_4;

import java.util.ArrayList;
import java.util.List;

//需求，把一个List的元素复制到另外一个List中去
public class GenericTest {

	static <T> void errorCopy(List<T> fromList, List<T> toList) {
		for (T element : fromList) {
			toList.add(element);
		}
	}

	//很巧妙的声明，第一个形参fromList的元素只要是第二个形参toList的子类或自身即可
	static <T> void rightCopy(List<? extends T> fromList, List<T> toList) {
		for (T element : fromList) {
			toList.add(element);
		}
	}
	
	static <T,S extends T> void rightCopy2(List<S> fromList, List<T> toList) {
		for (T element : fromList) {
			toList.add(element);
		}
	}
	public static void main(String[] args) {
		List<String> fromList= new ArrayList<String>();
		List<Object> toList  = new ArrayList<Object>();
		//编译错误，因为T不知道到底要替换成String还是Object
		//errorCopy(fromList,toList);
		
		rightCopy(fromList,toList);
		List<String> toList2= new ArrayList<String>();
		rightCopy(fromList,toList2);
		//rightCopy(toList,fromList);//编译错误，前一个实参的元素必须是后一个实参元素的子类或自身
		
		rightCopy2(fromList,toList);
	}

}
