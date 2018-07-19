package com.ks0100_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
RandomAccessFileTest3_1.txt和RandomAccessFileTest3_2.txt里面是4行诗句

黄河远上白云间，
一片孤城万仞山。
羌笛何须怨杨柳，
春风不度玉门关。
*/
public class RandomAccessFileTest3 {

	public static void main(String[] args) throws IOException{
		insert1("RandomAccessFileTest3_1.txt",12,"\n--插入的内容--\n");
		insert2("RandomAccessFileTest3_2.txt",12,"\n--插入的内容--\n");
	}
	/*
	 * RandomAccessFile如果直接将文件记录指针移动到中间位置后插入，那么新插入的内容会覆盖文件原有的内容
	 */
	public static void insert1(String filename,long pos,String insertContent) throws IOException{
		RandomAccessFile raf=new RandomAccessFile(filename, "rw");
		raf.seek(pos);
		raf.write(insertContent.getBytes());
		raf.close();
	}
	/*
	 * 如果需要插入内容不覆盖旧内容，需要先把插入点后面的内容读入缓冲区，等把需要插入的数据写入后，再讲缓冲区的内容追加到文件后面
	 */
	public static void insert2(String filename,long pos,String insertContent) throws IOException{

		
		RandomAccessFile raf=new RandomAccessFile(filename, "rw");
		raf.seek(pos);
		
		//创建一个临时文件，程序运行完后会自动删除
		File tmp=File.createTempFile("tmp", null);
		tmp.deleteOnExit();
		//把插入位置后面的数据都写到临时文件里，这个临时文件做缓冲
		FileOutputStream tmpOut=new FileOutputStream(tmp);
		FileInputStream tmpIn=new FileInputStream(tmp);
		byte[] buf=new byte[64];
		int hasRead=0;
		while((hasRead=raf.read(buf))>0){
			tmpOut.write(buf, 0, hasRead);
		}
		
		//指针重定位到插入位置，然后插入数据
		raf.seek(pos);
		raf.write(insertContent.getBytes());
		//把临时文件的内容追加到文件最后
		while((hasRead=tmpIn.read(buf))>0){
			raf.write(buf,0,hasRead);
		}
		raf.close();
		tmpOut.close();
		tmpIn.close();
	}
}
