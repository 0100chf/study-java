package com.ks0100_2.code2;

public class LocationFactory {
	public static Location createLocation(int type){
		Location l=null;
		//用工厂方法，创建对象，外部调用，就不需要知道构造对象的细节了
		if(type==1){
			l=new BeiJing(beiJingTime());
		}else if(type==2){
			l=new NewYork(newYorkTime());
		}
		return l;
	}
	
	private static String beiJingTime(){
		return "北京时间:2015年11月06日 14时14分01秒 ";
	}
	
	private static String newYorkTime(){
		return "Fri Aug 08 12:12:12 CST 2008 ";
	}
}
