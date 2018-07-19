package com.ks0100_3;

import java.io.File;

public class RecursionFile {

	public static void main(String[] args) {
		File srcFolder = new File(".");

		// 递归功能实现
		getAllJavaFilePaths(srcFolder);
	}

	private static void getAllJavaFilePaths(File srcFolder) {
		// 获取该目录下所有的文件或者文件夹的File数组
		File[] fileArray = srcFolder.listFiles();

		// 遍历该File数组，得到每一个File对象
		for (File file : fileArray) {
			// 判断该File对象是否是文件夹
			if (file.isDirectory()) {
				//方法递归，一层一层往下读文件
				getAllJavaFilePaths(file);
			} else {
				// 继续判断是否以.java结尾
				if (file.getName().endsWith(".java")) {
					// 就输出该文件的绝对路径
					System.out.println(file.getAbsolutePath());
				}
			}
		}
	}

}
