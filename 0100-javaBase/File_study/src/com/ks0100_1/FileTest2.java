package com.ks0100_1;

import java.io.File;
import java.io.IOException;

/*
 *创建功能：
 *public boolean createNewFile():创建文件 如果存在这样的文件，就不创建了
 *public boolean mkdir():创建文件夹 如果存在这样的文件夹，就不创建了
 *public boolean mkdirs():创建文件夹,如果父文件夹不存在，会帮你创建出来

 */
public class FileTest2 {

	//以下代码可以运行两遍以上，第二次运行，因为文件路径或文件都建立好，所以是false
	public static void main(String[] args) throws IOException{
		// 需求：我要在e盘下创建一个文件夹0100study
		File file = new File("e:\\0100study");
		System.out.println("mkdir:" + file.mkdir());

		// 需求:我要在e盘0100study文件夹下创建一个文件a.txt
		File file2 = new File("e:\\0100study\\a.txt");
		//如果e盘下没有0100study这个目录，而去创建文件，就会出现系统找不到指定的路径的异常，该异常是checked异常，需要处理，我们让main方法去标识抛出。
		System.out.println("createNewFile:" + file2.createNewFile());


		// 需求:如果没有 e:\\0100study\\aaa\\bbb\\ccc这个路径，需要建立这个路径下的所有文件夹
		File file3 = new File("e:\\0100study\\aaa\\bbb\\ccc");
		System.out.println("原来没有文件路径，可以建立一条文件路径，包括所有文件夹，mkdirs:" + file3.mkdirs());//mkdir()和mkdirs() 相差一个s

		// 看下面的这个东西：
		File file4 = new File("e:\\0100study\\111\\222\\b.txt");
		System.out.println("能这样建立b.txt文件吗？" + file4.mkdirs());
	}

}
