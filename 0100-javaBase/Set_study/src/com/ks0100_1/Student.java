package com.ks0100_1;

public class Student {
	// 成员变量
	private String name;
	private int age;

	// 构造方法
	public Student() {
		super();
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// 成员方法
	// getXxx()/setXxx()
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
	
	/*
	 * HashSet add方法 依赖对象的两个方法：
	 * int hashCode() 和boolean equals(Object obj)
	 *
	 * 以上重写了Object的方法后，名字和年龄一样的对象，判定为重复，所以不能add。
	 * 如果注释以下两个方法，那么HashSet会用Object的hashCode()和equals(...)方法
	 */
	public boolean equals(Object obj){
		if(obj instanceof Student){
			Student s=(Student)obj;
			if(s.getAge()==this.getAge()&&s.getName().equals(this.getName())){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	public int hashCode(){
		return this.getName().hashCode()+this.getAge();
	}
}
