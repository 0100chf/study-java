package com.ks0100_4;

/* 反编译class
 *1.dos到StringObjectPlus class目录下
 *2.运行 javap -c StringObjectPlus
 *3.看到new StringBuilder,StringBuilder append 方法 等，说明 字符串对象+字符串常量 是会生成StringBuilder对象的
 *4.
 */
public class StringObjectPlus {
	public static void main(String[] args) {
		String s ="";
		s+="java";
		s+=".net";
		System.out.println(s);
		/*
		 * jvm编译后等同于以下
		 * 	StringBuilder sb = new StringBuilder(s);
            sb.append("java");
            s=sb.toString();
            
            StringBuilder sb2 = new StringBuilder(s);
            sb2.append("java");
            s=sb2.toString();
		 * 
		 */
	}
}
