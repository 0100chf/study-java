package com.ks0100_1;

import java.util.ArrayList;
import java.util.List;

class A{
	public boolean equals(Object obj){
		return true;
	}
}
public class ListTest4 {

	public static void main(String[] args) {
		List list=new ArrayList();
		list.add("aaa");
		list.add("11");
		list.add("222");
		System.out.println("list:"+list);
		list.remove(new A());
		System.out.println("remove A类对象  list:"+list);//居然把第一个元素aaa给remove了。这里只是锻炼大家阅读源码的能力
		/*
		 * 我们可以看ArrayList源码
		 *    
		 public boolean remove(Object o) {
			if (o == null) {
		        for (int index = 0; index < size; index++)
					if (elementData[index] == null) {
					    fastRemove(index);
					    return true;
					}
			} else {
			    for (int index = 0; index < size; index++)
					if (o.equals(elementData[index])) { //A类的equals()方法始终为true，所以会移除第一个元素
					    fastRemove(index);
					    return true;
					}
		        }
			return false;
		    }
		 */
	}

}
