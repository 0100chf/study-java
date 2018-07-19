package com.ks0100_2.code2;

public class Client {

	public static void main(String[] args) {
		
		
//		Location l =new BeiJing(beiJingTime());//原来构造BeiJing这个对象，必须知道细节，现在不用了
		
		Location l=LocationFactory.createLocation(1);
		l.show();
		Location l2=LocationFactory.createLocation(2);
		l2.show();
	}

}
