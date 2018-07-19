package com.ks0100_3;

import java.io.Serializable;

public class Orientation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9154777525880592932L;
	//自定义枚举
	public static final Orientation HORIZONTAL=new Orientation(1);//水平方向
	public static final Orientation VERTICAL=new Orientation(2);//垂直方向
	
	private int value;
	private  Orientation(int value){
		this.value=value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public static Orientation getHorizontal() {
		return HORIZONTAL;
	}
	public static Orientation getVertical() {
		return VERTICAL;
	}
	
}
