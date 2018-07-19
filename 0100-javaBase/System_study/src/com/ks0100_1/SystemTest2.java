package com.ks0100_1;

import java.util.Arrays;
import java.util.Scanner;

public class SystemTest2 {

	public static void main(String[] args) {

		// 以下方法分别打开注释，一次只运行一个方法
		// 第一段
//		function1();

		// 第二段 System.currentTimeMillis() 返回以毫秒为单位的当前时间， 获取这样的数字对实际的程序编写意义不大
//		function2() ;

		/*
		 * 第三段
		 * 统计一段程序的运行时间
		 */
//		function3();
		
		/*
		 * 第四段用arraycopy(...) 复制数组 从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。
		 */
//		function4();

		// 第五段
		/*
		 * System.identityHashCode(a) 可以等同于获取内存地址
		 * 
		 */
//		function5();

		// 第六段  System.err.println()
		 function6();

	}

	static void function1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入两个整数，用空格、tab或回车分隔，第一个整数输入-1则退出:");
		while (sc.hasNext()) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			if(a==-1){
				System.exit(0);// 退出程序，按照惯例用0做参数，表示正常退出
			}else{
				//以下是一段异常处理的代码
				try{
					System.out.println("求两个整数的整除结果是:" + a/b); //捕捉有可能出现异常的代码
				}catch(Exception ex){
					//处理异常
					System.out.println("0不能作为除数");
					ex.printStackTrace();
					System.exit(-1);//退出程序，按照惯例用0做参数，表示异常终止
				}
			}
		}
	}

	static void function2() {
		System.out.println(System.currentTimeMillis());
	}
	static void function3() {
		long start = System.currentTimeMillis();
		for (int x = 0; x < 100000; x++) {
			System.out.println("hello" + x);
		}
		long end = System.currentTimeMillis();
		System.out.println("共耗时：" + (end - start) + "毫秒");
	}
	
	static void function4(){
		// 定义数组
		 int[] arr = { 11, 22, 33, 44, 55 };
		 int[] arr2 = { 6, 7, 8, 9, 10 };
		 //把数组打印出来
		 System.out.println("arr[]:"+Arrays.toString(arr));//Arrays这个工具类，以后会讲
		 System.out.println("arr2[]:"+Arrays.toString(arr2));
		 System.out.println("copy 前-----");
		 /*
		 * 请大家看这个代码的意思，学会看参数
		 * 参数 src 是源数组；srcPos
		 是从源数组的索引多少开始复制；dest是目标数组；destPos是从目标数组索引多少开始被覆盖；length是目标数组要被覆盖多长
		 */
		 System.arraycopy(arr, 1, arr2, 2, 2);
		
		 System.out.println("arr[]:"+Arrays.toString(arr));
		 System.out.println("arr2[]:"+Arrays.toString(arr2));
		 /*
		 * 怎样把一个数组完整的克隆出一份出来
		 */
		 int[] arr3=new int[arr.length];//动态初始化，用源数组的长度
		 System.arraycopy(arr, 0, arr3, 0,arr3.length);//开始复制，索引都从0开始，长度为数组长度，完全复制。
		 System.out.println("arr3[]:"+Arrays.toString(arr3));
		 System.out.println("arr==arr3:"+(arr==arr3));
	}
	
	static void function5(){

		String a = new String("qwe");
		String b = new String("qwe");
		System.out.println("字符串字符序列相同，hashcode一样，但是这两个字符串是不同对象的引用：");
		System.out.println("a==b:"+(a==b));
		System.out.println("a hashCode：" + a.hashCode());
		System.out.println("b hashCode：" + b.hashCode());
		/*
		 * 通过System.identityHashCode(Object x)方法可以获得特定对象的identityHashCode值，
		 * 这个特殊值可以唯一的标识该对象， 它是根据对象的地址计算得到的。
		 * 可以把该方法等同于，java获取变量的内存地址
		 */
		System.out.println("用System.identityHashCode(...) 来返回hashcode：");
		System.out.println("a identityHashCode：" + System.identityHashCode(a));
		System.out.println("b identityHashCode：" + System.identityHashCode(b));
		if(a==b){
			System.out.println("a 和 b 是同样对象引用");
		}
		if(System.identityHashCode(a)==System.identityHashCode(b)){
			System.out.println("a 和 b 是同样对象引用");
		}
	}
	
	static void function6(){
		System.err.println("错误了");
	}
}
