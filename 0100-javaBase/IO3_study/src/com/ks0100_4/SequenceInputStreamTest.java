package com.ks0100_4;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

public class SequenceInputStreamTest {

	public static void main(String[] args) throws IOException {
		merge("唐诗1.txt", "唐诗2.txt");
		List<String> files=Arrays.asList("唐诗1.txt","唐诗2.txt","唐诗3.txt");
		merge(files);
	}

	/**
	 * 需求把唐诗1，唐诗2合并到一个文本文件中去
	 * 
	 * @throws IOException
	 */
	public static void merge(String file1, String file2) throws IOException {
		// SequenceInputStream(InputStream s1, InputStream s2)
		// 需求：把ByteArrayStreamDemo.java和DataStreamDemo.java的内容复制到Copy.java中
		InputStream s1 = new FileInputStream(file1);
		InputStream s2 = new FileInputStream(file2);
		SequenceInputStream sis = new SequenceInputStream(s1, s2);// 合并输入流
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("唐诗合并1_out.txt"));

		// 按照以前怎么读写，现在还是怎么读写
		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = sis.read(bys)) != -1) {
			bos.write(bys, 0, len);
		}

		bos.close();
		sis.close();
		System.out.println("篇唐诗合并结束。。。。。。");
	}

	public static void merge(List<String> files) throws IOException {

		Vector<InputStream> v = new Vector<InputStream>();
		for (String filename : files) {
			InputStream s = new FileInputStream(filename);
			v.add(s);
		}

		Enumeration<InputStream> en = v.elements();
		SequenceInputStream sis = new SequenceInputStream(en);
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("唐诗合并2_out.txt"));

		// 如何写读写呢，其实很简单，你就按照以前怎么读写，现在还是怎么读写
		byte[] bys = new byte[1024];
		int len = 0;
		while ((len = sis.read(bys)) != -1) {
			bos.write(bys, 0, len);
		}

		bos.close();
		sis.close();
		System.out.println( files.size()+"篇唐诗合并结束。。。。。。");
	}

}
