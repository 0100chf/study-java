package com.ks0100_1;

/*
 * 线性同余法，自己创建一个随机数类。（不需要知道线性同余法）
	计算机随机数实现原理：
	1.计算机不能自己随机 
	2.通过物理方式实现真正的随机，比如掷钱币、骰子、转轮、使用电子元件的噪音、核裂变等等，把物理现象转换为计算机的数据，技术要求高。
	3.通过数学方式来实现，需要传人一个参数产生一个唯一的数字，这个参数就叫随机数种子。
	4.相同种子，在同一随机算法当中，会生成相同的"随机数序列“
	5.为了保证不重复，那么每次必须使用不同的种子。（换句话说，如果知道了种子数，那么就可以求出随机数来）

 */
public class MyRandom {
	
	private int seed;

	public MyRandom(int seed) {
		this.seed = seed;
	}

	/*
	 * 线性同余法：第n+1个数=(第n个数*29+37) % 1000
	 * 能保证产生一个序列的数，不会重复。
	 * 如seed=1000,则第1到200的数字不重复；seed=101,则第1到40的数字不重复
	 * 
	 */
	public int next() {
		
		int next = (seed * 29 + 37) % 1000;
		seed = next;
		return next;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		
		int seed=1000;
		//seed=101;
		//seed=new Long(System.currentTimeMillis()).intValue();
		MyRandom m=new MyRandom(seed);//根据seed不同，来生成不同区间范围的数字，"模拟随机"
		for(int i=0;i<1000;i++){
			System.out.println((i+1)+":"+m.next()); 
		}
		
	}
}
