package com.ks0100_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) throws Exception {
		Properties p=new Properties();
		p.setProperty("name", "0100");
		p.setProperty("password", "12345");
		/*
		 * new FileOutputStream(...)方法生成文件，以后I/O会讲
		 * 这里是保存文件
		 */
		p.store(new FileOutputStream("p.ini"), "");
		p.load(new FileInputStream("p.ini"));
		System.out.println(p);
		System.out.println("name:"+p.getProperty("name")+";password:"+p.getProperty("password"));
		System.out.println("pwd:"+p.getProperty("pwd"));
		//可以直接读取
		Properties p2=new Properties();
		p2.load(new FileInputStream("p2.properties"));//和后缀名无关
		System.out.println(p2);
	}

}
