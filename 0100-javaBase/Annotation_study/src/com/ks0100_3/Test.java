package com.ks0100_3;

@ClassTag
public class Test {
	
	//@ClassTag 只能在 类、接口(包括注解类型) 或enum上
	//@ClassTag
	void method1(){
	}
	
	@FieldTag
	int a;
	
	@MethodTag
	void method2(){
		
	}
	
	/*
	 * 还有CONSTRUCTOR，LOCAL_VARIABLE，PACKAGE，PARAMETER
	 * 自己去试验
	 */

}
