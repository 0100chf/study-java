package com.ks0100_2;

/*
 * 
 * 演示用Runtime来编译java文件，前提jdk环境变量配置好
 * 用dos命令行来编译运行，不要在eclipse，因为eclipse输出class路径问题
 * 1.dos 进入RuntimeTest3.java 路径
 * 2.编译RuntimeTest3.java：  javac -encoding utf-8 -d . RuntimeTest3.java，成功后生成com/ks0100_2/RuntimeTest3.class
 * 3.运行RuntimeTest3.java：java com.ks0100_1.RuntimeTest3 ,发现生成com/ks0100_2/Hello.class
 * 4.运行Hello.java: java com.ks0100_2.Hello,打印字符hello world.
 */
public class RuntimeTest3 {

	public static void main(String[] args) throws Exception{
		Runtime rt=Runtime.getRuntime();
		rt.exec("javac -d . Hello.java");
	}

}
