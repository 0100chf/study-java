package com.ks0100_1;

import java.io.File;
import java.util.Scanner;

public class ScannerDemo4 {

	//Scanner类还可以读取文件输入
	public static void main(String[] args) throws Exception{
		//读取test.abc文件的内容，注意路径，读取文件的根目录是工程的根目录
		Scanner sc=new Scanner(new File("test.abc"));//有关文件读取的内容在IO讲
		System.out.println("test.abc的内容如下：");
		while(sc.hasNextLine()){
			System.out.println(sc.nextLine());
		}
	}

}
