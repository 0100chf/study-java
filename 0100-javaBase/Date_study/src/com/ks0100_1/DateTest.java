package com.ks0100_1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) throws Exception {
		// 创建对象
		Date d = new Date();
		System.out.println("现在1:" + d);// 这个格式不是我们中文习惯的，参考Date类的toString()
		
		Date d2 = new Date(2016,5,1);//这是过时的方法，不应该使用，低版本的jdk有这样的方法，只是为了兼容低版本，所以还保留，但是按照规范不要使用
		
		System.out.println("-------把Date类转换为指定格式String类:");
		// Date -- String
		// 创建日期对象
		// 创建格式化对象
		SimpleDateFormat sdf = new SimpleDateFormat();// 看源码
		System.out.println("格式1==>" + sdf.format(d));
		
		// 给定模式
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		String s = sdf2.format(d);
		System.out.println("格式2 (yyyy年MM月dd日 HH:mm:ss) ==>" + s);
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy年MM月dd日");
		System.out.println("格式3 (yyyy年MM月dd日) ==>" + sdf3.format(d));
		
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy年mm月dd日");
		System.out.println("格式4 (yyyy年mm月dd日 )==>" + sdf4.format(d));// 不能小写mm，会出现错误数据

		SimpleDateFormat sdf5 = new SimpleDateFormat("MM月dd日 yyyy年  HH:mm:ss ");
		System.out.println("格式5 (MM月dd日 yyyy年  HH:mm:ss)==>" + sdf5.format(d));// 顺序可以颠倒

		System.out.println("----------把指定格式String类转换为Date类:");
		// String -- Date
		String str = "2008-08-08 12:12:12";
		// 在把一个字符串解析为日期的时候，请注意格式必须和给定的字符串格式匹配
		SimpleDateFormat sdf10 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dd = sdf10.parse(str);
		System.out.println(dd);

		SimpleDateFormat sdf11 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf11.parse(str));// 会省略时分秒 

	}


}
