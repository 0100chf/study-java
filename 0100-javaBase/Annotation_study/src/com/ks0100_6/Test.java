package com.ks0100_6;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@ClassTag
public class Test {
	
	@MethodTag
	void method1(){
	}
	
	@FieldTag
	int a;
	
	@MethodTag2
	void method2(){
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		Annotation[] array= Test.class.getAnnotations();
		for(Annotation an:array){
			System.out.println(an);
		}
		
		Method[] mArray=Test.class.getDeclaredMethods();
		for(Method m:mArray){
			System.out.println(m.getName());
			Annotation[] annotation= m.getAnnotations();
			for(Annotation an:annotation){
				System.out.println(an);
				//method2() 不会打印出注解，是因为其他注解都定义为运行时可见
				//即@Retention(RetentionPolicy.RUNTIME)
				//Annotation类只读取运行时可见的注解
			}
		}
		
	}

}
