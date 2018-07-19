package com.ks0100_2;

public class RuntimeTest {

	public static void main(String[] args) {
		
		Runtime rt=Runtime.getRuntime();
		System.out.println("处理器数量："+rt.availableProcessors());
		System.out.println("空闲内存数："+rt.freeMemory());//单位字节
		System.out.println("总内存数："+rt.totalMemory());//单位字节
		System.out.println("可用最大内存数："+rt.maxMemory());//单位字节
		
		
	}

}
