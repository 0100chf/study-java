package com.ks0100_4.code1;

/**
 * 最简单的单例模式,这也属于饿汉单例模式
 * 
 * @author chen haifeng
 *
 */
public class Singleton {
	
    private static Singleton instance = new Singleton();
    //私有构造方法，外部就不能实例化对象
    private Singleton() {}
    public static Singleton getInstance() {
        return instance;
    }
}
