package com.ks0100_4;


/**
 * 字符串相加操作的性能测试,s代表String对象
 * 1.String对象和字符串相加，如s += "java"
 * 2.测试StringBuffer append
 * 3.测试StringBuilder append
 * 4.测试字符串直接相加。 "I" + "love" + "java"
 * 5.测试String对象相加。s1+s2+s3
 * @author chen haifeng
 *
 */
public class PerformanceTest {
	private static int time = 50000;//循环次数

	public static void main(String[] args) {
		testString();
		testOptimalString ();
		testStringBuffer();
		testStringBuilder();
		test1String();
		test2String();
	}
	
	//String对象和字符串相加   测试s += "java";
	public static void testString() {
		String s = "";
		long begin = System.currentTimeMillis();
		for (int i = 0; i < time; i++) {
			s += "java";//s=s+"java";一样的
		}
		long over = System.currentTimeMillis();
		System.out.println("操作" + s.getClass().getName() + "类型使用的时间为：" + (over - begin) + "毫秒");
	}
	
	/*
	 * s += "java";
	 * 其实在编译的时候JVM优化成为如下
	        StringBuilder sb = new StringBuilder(s);
            sb.append("java");
            s=sb.toString();
                    如果每次 循环，将会产生   StringBuilder对象，所以非常消耗性能。
	 * 
	 */
    public static void testOptimalString () {
        String s="";
        long begin = System.currentTimeMillis();
        for(int i=0; i<time; i++){
            StringBuilder sb = new StringBuilder(s);
            sb.append("java");
            s=sb.toString();
        }
        long over = System.currentTimeMillis();
        System.out.println("模拟JVM优化操作的时间为："+(over-begin)+"毫秒");
    }
    
	//测试StringBuffer append
	public static void testStringBuffer() {
		StringBuffer sb = new StringBuffer();
		long begin = System.currentTimeMillis();
		for (int i = 0; i < time; i++) {
			sb.append("java");
		}
		long over = System.currentTimeMillis();
		System.out.println("操作" + sb.getClass().getName() + "类型使用的时间为：" + (over - begin) + "毫秒");
	}
	
	//测试StringBuilder append
	public static void testStringBuilder() {
		StringBuilder sb = new StringBuilder();
		long begin = System.currentTimeMillis();
		for (int i = 0; i < time; i++) {
			sb.append("java");
		}
		long over = System.currentTimeMillis();
		System.out.println("操作" + sb.getClass().getName() + "类型使用的时间为：" + (over - begin) + "毫秒");
	}

	//测试字符串直接相加，其实是常量池里面字符相加
	public static void test1String() {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < time; i++) {
			String s = "I" + "love" + "java";
		}
		long over = System.currentTimeMillis();
		System.out.println("字符串直接相加操作：" + (over - begin) + "毫秒");
	}

	//测试String对象相加，其实比字符串直接相加多一步变量引用而已。
	public static void test2String() {
		String s1 = "I";
		String s2 = "love";
		String s3 = "java";
		long begin = System.currentTimeMillis();
		for (int i = 0; i < time; i++) {
			String s = s1 + s2 + s3;
		}
		long over = System.currentTimeMillis();
		System.out.println("字符串间接相加操作：" + (over - begin) + "毫秒");
	}
}
