package com.ks0100_1;
//import static java.lang.Math.*;

public class MathTest {

	public static void main(String[] args) {
		// public static final double PI
		//System.out.println("Math.PI:" +PI);//用静态导入
		System.out.println("Math.PI:" + Math.PI);
		// public static final double E
		System.out.println("Math.E:" + Math.E);
		System.out.println("--------------");

		// public static int abs(int a)：绝对值
		System.out.println("绝对值  Math.abs(10):" + Math.abs(10));
		System.out.println("绝对值  Math.abs(-10):" + Math.abs(-10));
		System.out.println("--------------");

		// public static double ceil(double a):向上取整
		System.out.println("向上取整  Math.ceil(12.34):" + Math.ceil(12.34));
		System.out.println("向上取整  Math.ceil(12.56):" + Math.ceil(12.56));
		System.out.println("--------------");

		// public static double floor(double a):向下取整
		System.out.println("向下取整  Math.floor(12.34):" + Math.floor(12.34));
		System.out.println("向下取整 Math.floor(12.56) :" + Math.floor(12.56));
		System.out.println("--------------");

		// public static int max(int a,int b):最大值
		System.out.println("最大值 Math.max(12, 23):" + Math.max(12, 23));
		// 需求：我要获取三个数据中的最大值
		// 方法的嵌套调用
		System.out.println("三个数据中的最大值  Math.max(Math.max(12, 23), 18):" + Math.max(Math.max(12, 23), 18));
		// 需求：我要获取四个数据中的最大值
		System.out.println("个数据中的最大值 Math.max(Math.max(12, 78), Math.max(34, 56)):" + Math.max(Math.max(12, 78), Math.max(34, 56)));
		System.out.println("--------------");

		// public static double pow(double a,double b):a的b次幂
		System.out.println("2的3次幂 Math.pow(2, 3) :" + Math.pow(2, 3));
		System.out.println("--------------");

		// public static double random():随机数 [0.0,1.0)
		System.out.println("随机数 [0.0,1.0) Math.random():" + Math.random());
		// 获取一个1-100之间的随机数
		System.out.println("1-100之间的随机数 :" + ((int) (Math.random() * 100) + 1));//之后还会讲随机数
		System.out.println("--------------");

		// public static int round(float a) 四舍五入(参数为double的自学)
		System.out.println("四舍五入 Math.round(12.34f):" + Math.round(12.34f));
		System.out.println("四舍五 Math.round(12.56f):" + Math.round(12.56f));
		System.out.println("--------------");

		// public static double sqrt(double a):正平方根
		System.out.println("正平方根 Math.sqrt(4):" + Math.sqrt(4));
	}

}
