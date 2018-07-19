package com.ks0100_1;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class EnumerationTest {

	public static void main(String[] args) {
		Vector v=new Vector();
		v.add("0100");
		v.add("java");
		v.add("培训班");
		Hashtable h=new Hashtable();
		h.put("语文", 100);
		h.put("数学", 88);
		Enumeration e=v.elements();
		while(e.hasMoreElements()){
			System.out.println(e.nextElement());
		}
		Enumeration e2=h.keys();
		while(e2.hasMoreElements()){
			Object key=e2.nextElement();
			System.out.println(key+":"+h.get(key));
		}
	}

}
