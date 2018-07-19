package com.ks0100_4.code4;

public enum Singleton {

	/**
	 * 定义一个枚举的元素，它就代表Singleton的一个实例
	 * 属于饿汉模式
	 */
	instance;
	private Singleton(){
		System.out.println("实例化枚举---");
	}
	
	public static void main(String[] args) {
		System.out.println("----");
		for(int i=0;i<10;i++){
			Singleton s=Singleton.instance;
			System.out.println(System.identityHashCode(s));
		}
	}

}
