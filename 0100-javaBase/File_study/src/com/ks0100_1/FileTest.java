package com.ks0100_1;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		// File(String pathname)：根据一个路径得到File对象
		// 把e:\\demo\\a.txt封装成一个File对象
		File file = new File("E:\\demo\\a.txt");

		// File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
		File file2 = new File("E:\\demo", "a.txt");

		// File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
		File file3 = new File("e:\\demo");
		File file4 = new File(file3, "a.txt");
		//磁盘中可以没有a.txt文件，只是构造File对象，还没有真正去读写a.txt文件，所以不会有错
		System.out.println("over");
		// 以上三种方式其实效果一样
	}

}
