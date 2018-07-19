package com.ks0100_3;

import java.io.File;

public class RecursionDeleteFile {

	public static void main(String[] args) {

		File srcFolder = new File("./study2");// 如果没有study2文件夹，可以在项目根目录下解压study2.zip，解压到当前文件夹
		// 不能直接从根目录删除，
		// 看API说明：删除此抽象路径名表示的文件或文件夹。如果此路径名表示一个文件夹，则该文件夹必须为空才能删除。
		System.out.println(srcFolder.delete());
		// 递归实现
		deleteFolder(srcFolder);
	}

	private static void deleteFolder(File srcFolder) {
		// 获取该目录下的所有文件或者文件夹的File数组
		File[] fileArray = srcFolder.listFiles();

		if (fileArray != null) {
			// 遍历该File数组，得到每一个File对象
			for (File file : fileArray) {
				// 判断该File对象是否是文件夹
				if (file.isDirectory()) {
					deleteFolder(file);
				} else {
					System.out.println("删除文件:" + file.getName() + "---" + file.delete());//
				}
			}

			System.out.println("删除文件夹:" + srcFolder.getName() + "---" + srcFolder.delete());
		}
	}

}
