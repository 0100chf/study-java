package com.ks0100_2;

import java.io.FileInputStream;
import java.io.IOException;

public class Java6TryCatch {
	
	public static void main(String[] args) {
		
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("java.txt");
			System.out.println("FileInputStream 读取-----------:");
			int by = fis.read();
			System.out.println(by);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			//close 还有处理异常，好麻烦
			if(fis!=null){//严谨的做法
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				fis=null;//把流对象置为null,可以gc
				
			}
		}
	}
}
