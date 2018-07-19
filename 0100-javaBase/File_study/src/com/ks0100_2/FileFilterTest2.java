package com.ks0100_2;

import java.io.File;
import java.io.FilenameFilter;

class MyFilenameFilter implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name) {
		File file=new File(dir,name);
		System.out.println("accept:"+file.getName());
		if (file.isFile()) {
			// 继续判断是否以.jpg结尾
			if (name.endsWith(".jpg")) {
				return true;
			}
		}
		return false;
	}
}

public class FileFilterTest2 {

	public static void main(String[] args) {
		File file = new File("./study");
		String[] nameList=file.list(new MyFilenameFilter());
		
		for(String fileName:nameList){
			System.out.println(fileName);
		}
	}

}
