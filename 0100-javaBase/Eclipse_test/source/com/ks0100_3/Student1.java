package com.ks0100_3;

/*
 * 编写一个满足下列要求的类：
1)	为学生创建一个类，这个类包括每个学生的姓名（String）、ID（int）和状态（int）。
状态表示学生的年级：1表示新生，2表示二年级，3表示三年级，4表示四年级。
2)	可获得学生的姓名；
3)	可修改学生年级；
4)	实例化某个对象时，可根据给定的姓名、编号、年级生成。
 */
//创建学生类
public class Student1 {
	private int id;
	private String name;
	private int state;		
	Student1(int aid,String aname,int astate){
		id=aid;
		name=aname;
		state=astate;
	}		
	public void setState(int state){
		this.state=state;
	}		
	public String getName(){
		return name;
	}		
}
