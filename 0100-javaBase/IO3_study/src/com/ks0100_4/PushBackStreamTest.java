package com.ks0100_4;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

/*
 * 程序中试图找到文件中字符串"|"，当找到该字符的时候，打印目标字符串之前的内容
 */
public class PushBackStreamTest {

	public static void main(String[] args) {
		try{
			PushbackReader pr=new PushbackReader(new FileReader("pushBack.txt"),64);
			char[] buf=new char[32];
			String lastContent="";
			int hasRead=0;
			while( (hasRead=pr.read(buf))>0){
				String content=new String(buf,0,hasRead);
				int targerIndex=0;
				if( (targerIndex=(lastContent+content).indexOf("|"))>0){
					pr.unread((lastContent+content).toCharArray());
					//指定读取前面len个字符
					int len=targerIndex>32?32:targerIndex;
					//再次读取指定长度的内容（就是目标字符串之前的内容）
					pr.read(buf,0,len);
					System.out.println(new String(buf,0,len));
					break;
				}else{
					//打印上次读取的内容
					System.out.print(lastContent);
					//将本次内容设为上次读取的内容
					lastContent=content;
				}
			}
			pr.close();
		}catch(IOException ie){
			ie.printStackTrace();
		}
	}

}
