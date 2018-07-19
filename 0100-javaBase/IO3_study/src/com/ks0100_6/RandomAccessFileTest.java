package com.ks0100_6;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile("RandomAccessFileTest.txt", "r");
		System.out.println("文件指针的初始位置:"+raf.getFilePointer());
		//通过移动指针，可以从流的中间开始访问
		raf.seek(300);//参数pos - 从文件开头以字节为单位测量的偏移量位置，在该位置设置文件指针。 

		byte[] buf=new byte[1024];
		int hasRead=0;
		while((hasRead=raf.read(buf))>0){
			System.out.print(new String(buf,0,hasRead));
		}
		raf.close();
	}

}
