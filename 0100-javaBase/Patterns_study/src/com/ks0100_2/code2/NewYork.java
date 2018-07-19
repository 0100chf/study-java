package com.ks0100_2.code2;

public class NewYork implements Location{
	private String formatTime="";
	public NewYork(String formatTime){
		this.formatTime=formatTime;
	}
	public void show(){
		System.out.println("这里是美国纽约，现在是："+formatTime);
	}
}
