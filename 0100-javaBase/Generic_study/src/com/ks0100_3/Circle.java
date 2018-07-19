package com.ks0100_3;

public class Circle extends Shape{

	@Override
	public void draw(Canvas c) {
		System.out.println("在"+c.getName()+"上画 圆圈");
	}

}
