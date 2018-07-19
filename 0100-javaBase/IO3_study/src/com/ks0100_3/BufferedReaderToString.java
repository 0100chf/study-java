package com.ks0100_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * BufferedReader BufferedWriter用在读写文本文件的时候很好用，
 * 我这里只举了BufferedReader的用法，大家可以模拟copy的方法去复制粘帖文本文件，练习BufferedReader和BufferedWriter
 * 
 * 
 * @author chen haifeng
 *
 */
public class BufferedReaderToString {

	public static void main(String[] args) {
		System.out.println(toSqlFromText("test.sql", "sql.append(\"", " \");"));
	}

	public static String toSqlFromText(String fileName, String covertStart, String covertEnd) {
		StringBuilder sb = new StringBuilder();
		BufferedReader in=null;
		try {
			in = new BufferedReader(new FileReader(fileName));//用BufferedReader来包装
			String s;
			//可以一次读取一行的字符,这里用String变量s记录
			while ((s = in.readLine()) != null) {
				if (!s.equals("")) {
					sb.append(covertStart);
					sb.append(s);
					sb.append(covertEnd);
					sb.append("\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return sb.toString();
	}

	/**
	 * 在日后的工作中经常是写好查询sql（以后数据库会学）后，然后要通过字符串拼接的方式把sql语句嵌入到java代码里面，比较枯燥
	 * 我们可以把sql文件读出来，转换成我们需要的java代码，然后复制到指定的方法里就可以了
	 * 以下是模拟方法，并不是真实场景，以后就业班会学习
	 */
	
	public void test() {
		StringBuilder sql = new StringBuilder();
		//把打印出来的代码复制到以下位置
		
		runSql(sql.toString());
	}

	public void runSql(String sql) {
		System.out.println("运行sql");
	}
}
