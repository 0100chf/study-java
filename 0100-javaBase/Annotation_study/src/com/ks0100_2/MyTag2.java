package com.ks0100_2;

public @interface MyTag2 {
	//default后面表示默认值
	String name() default "小王";
	int age() default 20;
}
