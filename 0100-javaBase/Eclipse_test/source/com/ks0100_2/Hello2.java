package com.ks0100_2;
/*
 * 
 * 自动生成构造方法
	a:无参构造方法 在代码区域右键--source--Generate Constructors from Superclass
	快捷键: alt+shift+s+c (注意Constructors单词 c有下划线)
	b:带参构造方法 在代码区域右键--source--Generate Constructors using fields.. -- finish
	快捷键: alt+shift+s+o (注意Constructors单词 o有下划线)
	
	自动生成get/set方法
	在代码区域右键--source--Generate Getters and Setters...
	快捷键: alt+shift+s+r (注意Generate单词 r有下划线)

 */

import com.ks0100_1.Hello1;
import java.lang.System;
public class Hello2 {

	public static void main(String[] args) {
		new Hello1();

	}

	private String name;
	private int age;
	public Hello2(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Hello2() {
		super();
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	


	


	
}
