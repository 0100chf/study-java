package com.ks0100_4.code2;

/*
 * 饿汉式单例的思想，类加载到jvm的时候，静态Field会立即实例化对象
 * 类什么时候加载？以后也会学，先提一下
 * 1.创建对象：new，反射 Class.forName("Singleton2")，反序列化
 * 2.调用类的静态方法
 * 3.访问静态Field
 * 4.初始化某个类的子类，该子类的所有父类都会被初始化
 * 5.直接使用java.exe命令运行该类，或者执行该类的main方法。
 * 
 */
public class Singleton2 {
	
	//利用jvm类加载机制，是不会用线程安全问题
	 private static   Singleton2 instance = new Singleton2();//类加载的时候，实例化对象
	 
	 public static String test="test123";//不属于单例范围，只是为了测试类加载
    //私有构造方法，外部就不能实例化对象
    private Singleton2() {
    	System.out.println("实例化Singleton2--------");
    }
   
    public static Singleton2 getInstance() {
        return instance;
    }
    
    public void print(String s){
    	System.out.println("大写字母:"+s.toUpperCase());
    }
    
    public static void main(String[] args) {
		System.out.println("----");//类加载时，先会实例化静态化 Field： instance 
		
		for(int i=0;i<100;i++){
			Thread t=new Thread(){
				 public void run() {
					 Singleton2 s=Singleton2.getInstance();
				 }
			};
			t.start();
		}
	}
}
