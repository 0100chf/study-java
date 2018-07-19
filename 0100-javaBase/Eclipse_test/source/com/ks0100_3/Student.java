package com.ks0100_3;

//设计一个学生类Student，该类包括：三个private成员变量：学号 sNumber，姓名 sName，班级号 sClass。
public class Student {
	private String sNumber,sName;
	private int sClass;				
	public Student(String number,String name,int _class){
		sNumber=number;sName=name;sClass=_class;
	}			
	String getStdNo(){
		return sNumber;
	}
	String getStdName(){
		return sName;
	}
	int getClassNo(){
		return sClass;
	}			
	public static void main(String[] args){
		Student std=new Student("001","张三",2);		
		System.out.println("学号："+std.getStdNo());
		System.out.println("姓名："+std.getStdName());
		System.out.println("班号："+std.getClassNo());		
	}
}
