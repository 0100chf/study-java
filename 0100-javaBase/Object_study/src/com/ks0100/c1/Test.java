package com.ks0100.c1;


/*

public int hashCode() :获取哈希码(hashcode)
public final Class getClass()
public String toString()
public boolean equals(Object obj)
protected void finalize()
protected Object clone()

*/

 
public class Test {

	public static void main(String[] args) {
		
		Person p1=new Person();
		System.out.println("p1.hashCode():"+p1.hashCode());
		Person p2=new Person();
		System.out.println("p2.hashCode():"+p2.hashCode());
		
		
		if(p1==p2){
			System.out.println("p1==p2");
		}else{
			System.out.println("p1!=p2");
		}
		
		Person p4=p1;//对象p4和p1引用同一个地址空间
		if(p4==p1){
			System.out.println("p4==p1");
			//变量引用的对象相等，即引用同一个地址空间，hashCode肯定相等。
			System.out.println("p4.hashCode():"+p4.hashCode());
			System.out.println("p1.hashCode():"+p1.hashCode());
		}else{
			System.out.println("p4!=p1");
		}
		System.out.println("---------------------");
		System.out.println(p1.getClass());//返回此 Object 的运行时类
		System.out.println(p1.getClass().getName());//以 String 的形式返回此 Class 对象所表示的实体
		System.out.println(p1);
		System.out.println(p1.toString());//查看源码，对我们实际上面没有意义，可以重写该方法，看com.ks0100.c2.Person
		//借用源码，打印出和上面一行代码一样的值
		System.out.println(p1.getClass().getName() + '@'+ Integer.toHexString(p1.hashCode()));
		
		System.out.println("---------------------");
		System.out.println("有的人认为对象的哈希码一样，对象的地址空间就是一样的，这是错误的。比如字符串对象的hashcode()就是重写的");

		String a=new String("qwe");//String a="qwe";
		String b=new String("qwe");
		System.out.println("a hashCode："+a.hashCode());
		System.out.println("b hashCode："+b.hashCode());
		if(a==b){
			System.out.println("a==b");
		}else{
			System.out.println("a!=b");
		}
		System.out.println("对象的hashCode相等，但是并不表示对象相等");

		/*
		 * 原因是String类重写了hashCode()方法，把字符串中的每个字符转换为一个int值，然后通过一个公式来计算，那么
		 * 只要字符串中的字符中都相同，hashcode就一样。
		 * 所以字符串对象的hashcode 和内存地址没有任何关系。
		 * 看String源码
		 */
		
		//千万不要用a.hashCode()==b.hashCode()来判断是不是一个对象
	}

}
