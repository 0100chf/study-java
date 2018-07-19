package com.ks0100_1;

/*
 * 基本类型和字符串的相互转换
 */
public class WrapperTest2 {

	public static void main(String[] args) {
		
		System.out.println("********把特定字符串转换为基本类型变量********");
		String intStr="123";
		//把一个特定字符串转换成int变量
		int it1=Integer.parseInt(intStr);//利用包装类的静态方法parseXxx(String str);
		int it2=new Integer(intStr);//构造成包装类后，自动拆箱转换
		System.out.println(it2);
		
		String floatstr="4.56";
		//把一个特定字符串转换成float变量
		float ft1=Float.parseFloat(floatstr);
		float ft2=new Float(floatstr);
		System.out.println(ft2);
		
		
//		Long lobject=new Long("ads");//运行时出现 java.lang.NumberFormatException异常
		
		System.out.println("********把基本类型变量转换为String变量********");
		//把一个float变量转换成String变量
		String ftstr=String.valueOf(2.345f);
		String ftstr2=""+2.345f;
		System.out.println(ftstr);
		System.out.println(ftstr2);
		
		//把一个double变量转换成String变量
		String dbstr=String.valueOf(3.344);
		String dbstr2=""+3.344;
		System.out.println(dbstr);
		System.out.println(dbstr2);
		
		//把一个boolean变量转换成String变量
		String boolStr=String.valueOf(true);
		System.out.println(boolStr);
		System.out.println(true+"");
		
	}

}
