package com.ks0100_2;

import java.io.File;
import java.io.FilenameFilter;

public class FileFilterTest3 {
	public static void main(String[] args) {
		File file = new File("./study");

		//实现匿名内部类的方法，一次性用完
		String[] nameList = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir, name).isFile() && name.endsWith(".jpg");
			}
		});

		// 遍历
		for(String fileName:nameList){
			System.out.println(fileName);
		}
	}
}
