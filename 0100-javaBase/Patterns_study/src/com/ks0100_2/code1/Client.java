package com.ks0100_2.code1;


public class Client {

	public static void main(String[] args) {
		
		//旧的接口使用方式
//		Api api=new Impl1();
//		api.test1("做个小测试");
		
		Api api= Factory.createApi(2);
		//和旧的接口使用方式的不同在于，现在用工厂类的静态方法来创建对象了
		//避免了在外部调用的时候，知道了内部对象是怎么去实例化的，我们来看code2包会更好理解简单工厂
		api.test1("用简单工厂模式");
		
	}

}
