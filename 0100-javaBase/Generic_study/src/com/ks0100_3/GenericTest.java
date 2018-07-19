package com.ks0100_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenericTest {

	public static void main(String[] args) {
		GenericTest g=new GenericTest();
		List<String> strList=new ArrayList<String>(); 
		List<Integer> iList=new ArrayList<Integer>();
		//g.printList(strList);
		/*编译错误，List<Object> 和List<String>虽然还是一个class，
		 * 但是，作为参数，List<String>可不是List<Object>的子类，可以转型的
		 */
		g.printList2(strList);
		g.printList2(iList);
		Set<String> strSet=new HashSet<String>();
		Set<Integer> iSet=new HashSet<Integer>();
		g.printSet(strSet);
		g.printSet(iSet);
		Map<String,String> strMap=new HashMap<String,String>();
		Map<Object,Object> objMap=new HashMap<Object,Object>();
		g.printMap(strMap);
		g.printMap(objMap);
	}

	public void printList(List<Object> list){
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	
	//用通配符 <?>可以解决问题
	public void printList2(List<?> list){
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	
	public void printSet(Set<?> set){
		Iterator it=set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

	public void printMap(Map<?,?> map){
		  Set<?> keys=map.keySet();
		  //下面不遍历了，key,value要转型了
	}
}
