package com.ks0100_3;


public class Factory {
	
	//和简单工厂区别在于，创建对象的方法不需要对外暴露，只对子类或者包内暴露，所以不需要用静态方法，并公开
	protected  Api createApi(int condition){
		Api api=null;
		if(condition==1){
			api=new Impl1();
		}else if(condition==2){
			api=new Impl2();
		}
		return api;
	}
	
	public void factoryMethod(int condition,String s){
		Api api=createApi(condition);
		api.test1(s);
	}
}
