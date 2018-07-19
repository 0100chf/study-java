package com.ks0100_5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RedirectIn {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("redirectIn.txt");
		System.setIn(fis);
		
		//本来接受键盘输入是没有上面两段代码的，现在不会接受键盘输入，因为输入流重定向，从文件redirectIn.txt里读取输入
		Scanner sc=new Scanner(System.in);
		System.out.println("开始输入:");
		//只把 回车键作为分隔符
		sc.useDelimiter("\n");
		while(sc.hasNext()){
			System.out.println("键盘输入的内容是:"+sc.next());
		}
	}

}
