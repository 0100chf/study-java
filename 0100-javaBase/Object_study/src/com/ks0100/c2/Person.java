package com.ks0100.c2;

public class Person {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//private String toString(){ //思考为什么不能用private？
	public String toString(){
		return "名字:"+name+";年龄:"+age;
	}
	
	/*
	 * 重写equals方法，要求类型必须相等，并且名字和年龄都相等，最后Person对象才相等
	 * 
	 */
	
	public boolean equals(Object obj) {
		//为了提高效率
		if(this == obj){
			return true;
		}
		
		//instanceof运算符  判断该对象名是否属于一个类型
		//用法，类型转换之前用
		if(!(obj instanceof Person)){
			return false;
		}
		//如果是就继续
		Person p = (Person)obj;
		
		//注意字符串String类用==判断，是比较地址是不是相等，而我们只要字符串的值相等就可以了，比如名字都叫小李就相等。所以用String类的equals方法。
//		if(this.name.equals(p.name)&& this.age ==p.age){
//			return true;
//		}else{
//			return false;
//		}
			
		return this.name.equals(p.name) && this.age ==p.age;
	}
	
/*	@Override
	protected Person clone() throws CloneNotSupportedException { //抛出Clone不支持的异常，异常以后讲
		return (Person)super.clone();
	}*/
	
}
