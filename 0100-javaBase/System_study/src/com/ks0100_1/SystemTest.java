package com.ks0100_1;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//这些代码可以收藏
public class SystemTest {

	public static void main(String[] args) {
		System.out.println("***********获取系统所有的环境变量***********");
		// 用System.getenv()来获取系统所有的环境变量,返回Map，是一个数据结构，以后集合讲
		Map<String, String> env = System.getenv();
		for (String name : env.keySet()) {
			System.out.println(name + "-->" + env.get(name));
		}
		System.out.println("*********打印环境变量JAVA_HOME:************");
		// 用System.getenv(String name)获取指定的环境变量
		System.out.println(System.getenv("JAVA_HOME"));
		System.out.println("*********打印环境变量path:************");
		System.out.println(System.getenv("path"));
		System.out.println("***********获取所有的系统属性***********");
		// 用System.getProperties()来获取所有的系统属性
		Set properties = System.getProperties().keySet();
		Iterator<String> it = properties.iterator();
		while (it.hasNext()) {
			String propertyName = it.next();
			System.out.println(propertyName + "-->" + System.getProperty(propertyName));
		}
		System.out.println("*********打印重要的系统属性************");
		System.out.println("Java运行时环境版本:" + System.getProperty("java.version"));
		System.out.println("Java 运行时环境供应商:" + System.getProperty("java.vendor"));
		//System.out.println("Java 供应商的URL:" + System.getProperty("java.vendor.url"));
		System.out.println("jre目录:" + System.getProperty("java.home"));
		//System.out.println("Java 虚拟机规范版本:" + System.getProperty("java.vm.specification.version"));
		System.out.println("Java 编译类的版本号:" + System.getProperty("java.class.version"));//java6编译的是50.0；java7编译的是51.0
		System.out.println("Java 编译类的路径(classpath)：" + System.getProperty("java.class.path"));
		//System.out.println("加载库时搜索的路径列表:\n" + System.getProperty("java.library.path"));
		//System.out.println("默认的临时文件路径:\n" + System.getProperty("java.io.tmpdir"));
		//System.out.println("要使用的 JIT 编译器的名称:\n" + System.getProperty("java.compiler"));
		//System.out.println("一个或多个扩展目录的路径:\n" + System.getProperty("java.ext.dirs"));
		System.out.println("java文件编码:" + System.getProperty("file.encoding"));//可以把文件保存格式设置成gbk，试验一下
		System.out.println("操作系统的名称:" + System.getProperty("os.name"));
		System.out.println("操作系统的架构:" + System.getProperty("os.arch"));
		System.out.println("操作系统的版本:" + System.getProperty("os.version"));
		//System.out.println("文件分隔符（在 UNIX 系统中是“/”）:" + System.getProperty("file.separator"));
		//System.out.println("路径分隔符（在 UNIX 系统中是“:”）:" + System.getProperty("path.separator"));
		//System.out.println("行分隔符（在 UNIX 系统中是“/n”）:" + System.getProperty("line.separator"));
		System.out.println("用户的账户名称:" + System.getProperty("user.name"));
		//System.out.println("用户的主目录:" + System.getProperty("user.home"));
		//System.out.println("用户的当前工作目录:" + System.getProperty("user.dir"));
	}

}
