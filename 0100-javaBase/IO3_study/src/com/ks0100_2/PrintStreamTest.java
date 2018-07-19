package com.ks0100_2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintStreamTest {

	public static void main(String[] args) throws IOException {
		System.out.println("输出到test_out.txt");
		FileOutputStream fos=new FileOutputStream("test_out.txt");
		PrintStream ps=new PrintStream(fos);//把FileOutputStream对象包装了一下
		ps.println("我们现在学习java编程");//这样就不用考虑 用转义字符\n，来换行了
		ps.print(new PrintStreamTest());
		ps.close();
		fos.close();
		System.out.println("输出到test_out.txt");
		//效果和上面一致
		FileOutputStream fos2=new FileOutputStream("test2_out.txt");
		PrintWriter pw=new PrintWriter(fos2);//把FileOutputStream对象包装了一下
		pw.println("我们现在学习java编程");
		pw.print(new PrintStreamTest());
		pw.close();
		fos2.close();
		
	}

}
