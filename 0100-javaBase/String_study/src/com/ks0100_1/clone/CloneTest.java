package com.ks0100_1.clone;

/**
    这个类和之前的Object 类举例的CloneTest一样
 *
 */
public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException{//抛出异常，异常以后讲
		Person p1=new Person();
		p1.setAge(20);
		p1.setName("小李");
		Address address1=new Address("昆山");
		p1.setAddress(address1);
		
		System.out.println("从p1中克隆出一个新的Person对象p2，比较两个对象的地址空间");
		Person p2=p1.clone();
		if(p1==p2){
			System.out.println("p1==p2");
		}else{
			System.out.println("p1!=p2,克隆对象");
		}
		
		System.out.println("打印一下p2的成员变量");
		System.out.println("p2 name="+p2.getName());
		System.out.println("p2 age="+p2.getAge());
		System.out.println("p2 address="+p2.getAddress());//Address重写了toString()方法，返回place成员变量
		
		System.out.println("比较一下p1和p2的成员变量address引用的地址空间 ");
		if(p1.getAddress()==p2.getAddress()){
			System.out.println("浅克隆！！");
			System.out.println("p1 address ==p2 address");
		}else{
			System.out.println("深克隆！！");
			System.out.println("p1 address !=p2 address");
		}
		
		System.out.println("比较一下p1和p2的成员变量name引用的地址空间 ");
		if(p1.getName()==p2.getName()){
			System.out.println("浅克隆！！");
			System.out.println("p1 name ==p2 name");
		}else{
			System.out.println("深克隆！！");
			System.out.println("p1 name !=p2 name");
		}
		
		System.out.println("修改p2 的name为 小王");
		p2.setName("小王");
		System.out.println("p1 name="+p1.getName());
		System.out.println("p2 name="+p2.getName());
		
		System.out.println("再比较name成员变量");//克隆出来的对象p2的name成员变量 重新引用了新的字符串对象"小王"
		if(p1.getName()==p2.getName()){
			System.out.println("p1 name ==p2 name");
		}else{
			System.out.println("p1 name !=p2 name");
		}
	}

}
