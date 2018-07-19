package com.ks0100_2;

import java.io.File;

public class FileFilterTest {

	public static void main(String[] args) {
		
		File file = new File("./study");

		// 获取该目录下所有文件或者文件夹的File数组
		File[] fileArray = file.listFiles();

		// 遍历该File数组，得到每一个File对象，然后判断
		for (File f : fileArray) {
			// 是否是文件
			if (f.isFile()) {
				// 继续判断是否以.jpg结尾
				if (f.getName().endsWith(".jpg")) {
					// 就输出该文件名称
					System.out.println(f.getName());
				}
			}
		}
	}

}
