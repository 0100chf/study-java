package com.ks0100_3;

import java.util.ArrayList;
import java.util.Collection;

public class Canvas2 {

	public static void main(String[] args) {
		// 泛型如果明确的写的时候，前后必须一致
		Collection<Object> c1 = new ArrayList<Object>();
		// Collection<Object> c2 = new ArrayList<Shape>();//编译错误
		// Collection<Object> c3 = new ArrayList<Circle>();//编译错误
		// Collection<Object> c4 = new ArrayList<Rectangle>();//编译错误

		// ?表示任意的类型都是可以的
		Collection<?> c5 = new ArrayList<Object>();
		Collection<?> c6 = new ArrayList<Shape>();
		Collection<?> c7 = new ArrayList<Circle>();
		Collection<?> c8 = new ArrayList<Rectangle>();

		// ? extends E:设定类型通配符的上限，E及其子类
		// Collection<? extends Shape> c9 = new ArrayList<Object>();//编译错误
		Collection<? extends Shape> c10 = new ArrayList<Shape>();
		Collection<? extends Shape> c11 = new ArrayList<Circle>();
		Collection<? extends Shape> c12 = new ArrayList<Rectangle>();

		// ? super E:设定类型通配符的下限，E极其父类
		Collection<? super Shape> c13 = new ArrayList<Object>();
		Collection<? super Shape> c14 = new ArrayList<Shape>();
		// Collection<? super Shape> c15 = new ArrayList<Circle>();//编译错误
		// Collection<? super Shape> c16 = new ArrayList<Rectangle>();//编译错误
	}

}
