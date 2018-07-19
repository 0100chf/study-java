package com.ks0100_6.code1;

//装饰者模式的类
public class Decorator implements Component{

	private Component component;
	
	public Decorator(Component component) {
		this.component = component;
	}

	public Decorator(){}
	
	/*
	 *业务方法，委托给构件component
	 */
	@Override
	public void method() {
		//这里写，自己的方法。。。
		
		component.method();
		
		//这里写，自己的方法。。。
	}

}
