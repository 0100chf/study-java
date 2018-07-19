package com.ks0100_3;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Orientation2 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6688647481019454826L;
	// 自定义枚举
	public static final Orientation2 HORIZONTAL = new Orientation2(1);// 水平方向
	public static final Orientation2 VERTICAL = new Orientation2(2);// 垂直方向

	private int value;

	private Orientation2(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static Orientation2 getHorizontal() {
		return HORIZONTAL;
	}

	public static Orientation2 getVertical() {
		return VERTICAL;
	}

	//readResolve(...)方法是特殊签名的方法，不是实现接口的方法
	private Object readResolve() throws ObjectStreamException{
		System.out.println("Orientation2 readResolve()---------- ");
		if(value==1){
			return HORIZONTAL;
		}else if(value==2){
			return VERTICAL;
		}
		return null;
	}
}
