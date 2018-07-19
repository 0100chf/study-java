package com.ks0100_4.code3;


/**
 * 用双重检查加锁机制，来改进懒汉单例模式，使得线程安全
 * 所谓双重检查加锁机制指的是，并不是每次进入 getInstance() 方法都需要同步，而是先不同步，
 * 进入方法过后，先检查实例是否存在，如果不存在才进入下面的同步块，这是第一重检查。
 * 进入同步块过后，再次检查实例是否存在，如果不存在，就在同步的情况下创建一个实例，这是第二重检查。
 * 这样一来，就需要同步一次了，从而减少了多次在同步情况下进行判断所浪费的时间
 * 
 */
public class Singleton {
	
	/*用volatile关键字修饰，表示该Field instance将不会被本地线程缓存，
	 * 所有对该变量的读写都是直接操作共享内存,从而确保多个线程能正确的处理该变量
	*/
    private volatile static Singleton instance = null;
    
    //私有构造方法，外部就不能实例化对象
    private Singleton() { 
    	System.out.println("实例化Singleton...");
    }

    //用synchronized直接修饰方法，效率会低，所以用双重检查加锁机制
//    public synchronized  static Singleton getInstance(){
//    	 .....
//    }
    /*有线程安全的问题，如果是多线程，有可能会生成两个实例
    */
    public static Singleton getInstance() {
    	//先检查实例是否存在，如果不存在才进入下面的同步块
        if (instance == null) {
        	/*synchronized 是同步的意思，
        	 * 表示多线程进入该方法的时候，一个线程进来，先关门，后面的线程等待，
        	 * 一个线程执行完同步块里的方法后，打开门出去，下一个线程进来，关门，其他线程一样等待
        	 * 
        	 */
        	synchronized(Singleton.class){
        		if (instance == null) {
        			instance = new Singleton();
        		}
        	}
        }
        return instance;
    }
    public static void main(String[] args) {
    	System.out.println("-----");
//    	Singleton s=Singleton.getInstance();//只要第一次调用该单例对象的时候，才会实例化
    	long start=System.currentTimeMillis();
		for(int i=0;i<100;i++){
			Thread t=new Thread(){
				 public void run() {
					 Singleton s=Singleton.getInstance();
				 }
			};
			t.start();
		}
		long end=System.currentTimeMillis();
//		System.out.println("运行时间:"+(end-start));
    }
}
