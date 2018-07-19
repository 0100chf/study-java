package com.ks0100_2.code2;

public class BeiJing  implements Location{
	
	private String formatTime="";
	public BeiJing(String formatTime){
		this.formatTime=formatTime;
	}
	public void show(){
		System.out.println("这里是中国北京，现在是："+formatTime);
	}
}
