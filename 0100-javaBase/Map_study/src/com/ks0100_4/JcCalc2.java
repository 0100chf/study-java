package com.ks0100_4;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/*
 * 计算大数阶乘，1*2*3*4*...*i
 * 用map做缓存优化，我们看到时间缩短了一倍多。并且，只要有计算结果就保存到缓存里。不是每次都去计算
 * 在java程序里面，缓存的实现经常用map，我这里只是给个很简单的例子。项目上的缓存要考虑封装，线程安全，还有命中率，淘汰算法等。
 */
public class JcCalc2 {
	//先预定10000个元素容量
	private static Map map=new HashMap(10000);
	
	public static void main(String[] args) {
		
		long current=System.currentTimeMillis();
		int loop=1300;
		for(int i=1;i<=loop;i++){
			System.out.println(i+":"+calc(BigInteger.valueOf(i)));
		}
		System.out.println("运行第二遍--------------------------");
		//利用缓存，第二遍开始就不计算，而是之间取缓存里的结果
		for(int i=1;i<=loop;i++){
			System.out.println(i+":"+calc(BigInteger.valueOf(i)));
		}
		System.out.println("运行了:"+(System.currentTimeMillis()-current)+"毫秒");
	}
	private static BigInteger calc(BigInteger i){
		//0的阶乘是1
		if(i.compareTo(BigInteger.valueOf(0))==0){
			return BigInteger.valueOf(1);
		}else{
			//从缓存中查找value的阶乘
			BigInteger factor=(BigInteger)map.get(i);
			if(factor!=null){
				return factor;
			}
			//subtract是减法 a=i-1
			BigInteger a=i.subtract(BigInteger.valueOf(1));
			factor=calc(a).multiply(i);
			//把阶乘结果存入缓存
			map.put(i, factor);
			return factor;
		}
	}
}
