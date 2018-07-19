package com.ks0100_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderWriterTest {

	public static void main(String[] args) {
		try {
			System.out.println("请输入字符，您的输入会被保存，输入单词quit，退出：");
			// 缓冲System.in输入流
			// System.in是位流，可以通过InputStreamReader将其转换为字符流
			BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
			// 缓冲FileWriter
			BufferedWriter bufWriter = new BufferedWriter(new FileWriter("output.txt"));

			String input = null;

			// 每读一行进行一次写入动作
			while (!(input = bufReader.readLine()).equals("quit")) {
				bufWriter.write(input);
				// newLine()方法写入与操作系统相依的换行字符，依执行环境当时的OS来决定该输出那种换行字符
				bufWriter.newLine();
				
				//bufWriter.flush();//flush()是把缓冲 扫到目的地，这里是output.txt文件里，每换行，便写到文件一次。
			}
			bufReader.close();
			bufWriter.close();//会自动flush()
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("没有指定文件");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
