package com.ks0100_5;

@InheritedTag 
class Base{
	
}

//子类没有用注解修饰，但是Base因为用@InheritedTag 修饰。
//而@InheritedTag里面有@Inherited做标记，
//表示Base的子类默认都会用@InheritedTag修饰，这样不需要每个子类都写注解修饰了
class Sub extends Base{

}

class Test{
	public static void main(String[] args) {
		//从方法名就知道，是否存在注解
		System.out.println(Sub.class.isAnnotationPresent(InheritedTag.class));
	}
}

