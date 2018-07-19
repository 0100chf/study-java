package com.ks0100_4.code2;

/**
 * 这种单例叫懒汉式单例，即静态Field不会立即实例化，只有调用过实例化方法的时候，才被实例化，
 * 这种思想也称为延迟加载，也就是说用的时候才加载，加载完了，一直保存在内存中
 * 
 * @author chen haifeng
 *
 */
public class Singleton {
	//static修饰，Field保存在静态区里，属于"类的范围",不会被gc
    private static Singleton instance = null;
    
    public static String test="test123";//不属于单例范围，只是为了测试类加载
    //私有构造方法，外部就不能实例化对象
    private Singleton() {
    	System.out.println("实例化Singleton---------");
    }

    /*有线程安全的问题，如果是多线程，有可能会生成两个实例
    */
    public static Singleton getInstance() {
    	//两个线程以上同时进来，instance==null，那么就会执行多次new Singleton()，生成多个实例
        if (instance == null) {
              instance = new Singleton();
        }
        return instance;
    }
    
    public void print(String s){
    	System.out.println("大写字母:"+s.toUpperCase());//toUpperCase() 是String类的方法，以后还会讲
    }
    public static void main(String[] args) {
		System.out.println("-----");//不会实例化Field instance
		
		//运行多次有可能实例化多次
		for(int i=0;i<100;i++){
			Thread t=new Thread(){
				 public void run() {
					 Singleton s=Singleton.getInstance();
				 }
			};
			t.start();
		}

		//Singleton s=Singleton.getInstance();//用的时候来实例化单例
	}
}
