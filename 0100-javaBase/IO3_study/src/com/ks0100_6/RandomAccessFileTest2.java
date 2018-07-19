package com.ks0100_6;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest2 {

	public static void main(String[] args) throws IOException {
		//rw,用读写模式，打开RandomAccessFile对象
		RandomAccessFile raf=new RandomAccessFile("RandomAccessFileTest2.txt", "rw");
		raf.seek(raf.length());//移动到流的最后
		raf.write("\n往后追加\n".getBytes());
		raf.close();
		System.out.println("追加成功，查看RandomAccessFileTest2.txt");
	}

}
