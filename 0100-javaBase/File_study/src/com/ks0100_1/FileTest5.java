package com.ks0100_1;

import java.io.File;

public class FileTest5 {

	public static void main(String[] args) {
		// 指定一个目录
		File file = new File("e:\\");
		System.out.println("获取指定目录下的所有文件或者文件夹的 名称 字符串数组---------");
		// public String[] list():获取指定目录下的所有文件或者文件夹的 名称数组
		String[] strArray = file.list();
		for (String s : strArray) {
			System.out.println(s);
		}
		System.out.println("获取指定目录下的所有文件或者文件夹的 File类数组-----------");

		// public File[] listFiles():获取指定目录下的所有文件或者文件夹的 File数组
		File[] fileArray = file.listFiles();
		for (File f : fileArray) {
			System.out.println(f.getAbsoluteFile().getAbsolutePath());
		}
	}

}
