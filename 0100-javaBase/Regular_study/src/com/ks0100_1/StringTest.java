package com.ks0100_1;

import java.text.MessageFormat;

public class StringTest {

	public static void main(String[] args) {
		
		parseIp1("192.168.10.5[port=8080]");
		parseIp2("192.168.10.5[port=21,type=FTP]");
		parseIp2("192.168.10.5[port=21]");
		System.out.println("判断ks0100@ks0100.com是email:"+validateEmail("ks0100@ks0100.com") );
		System.out.println("判断ks0100是email:"+validateEmail("ks0100") );
		System.out.println("判断@ks0100.com是email:"+validateEmail("@ks0100.com") );
	}

	//解析字符串,192.168.10.5[port=8080],打印ip地址和端口号。
	public static void parseIp1(String text){
		int leftBraceIndex=text.indexOf('[');
		String ipAddr=text.substring(0, leftBraceIndex);//如果ip地址前面是其他字符，那就复杂了
		int equalsIndex=text.indexOf('=');
		String port=text.substring(equalsIndex+1,text.length()-1);
		System.out.println("IP地址是:"+ipAddr+";端口是:"+port);
	}
	/*
	 * 192.168.10.5[port=21,type=FTP]
	 * 这个字符串表示IP地址为192.168.10.5的服务器的21端口提，采用FTP协议，其中如果",type=FTP"部分省略，
	 * 则默认采用HTTP协议。请用程序解析此字符串，然后打印出IP地址，端口，协议"
	 */
	public  static void parseIp2(String text){
		int leftBraceIndex=text.indexOf('[');
		String ipAddr=text.substring(0, leftBraceIndex);
		String subStr=text.substring(leftBraceIndex+1,text.length()-1);
		String[] strings=subStr.split(",");
		String portString =strings[0];
		String port=portString.split("=")[1];
		String type="HTTP";
		if(strings.length==2){
			String typeString=strings[1];
			type=typeString.split("=")[1];
		}
		
		String msg=MessageFormat.format("IP地址是:{0}，服务器端口是:{1}，协议是:{2}", 
				new Object[]{ipAddr,port,type});
		System.out.println(msg);
	}
	
	//判断一个字符串是不是email
	public  static boolean validateEmail(String text){
		int atIndex=text.indexOf('@');
		int dotLastIndex=text.lastIndexOf('.');
		//必须含有@和.
		if(atIndex<0||dotLastIndex<0){
			return false;
		}
		int textLen=text.length();
		
		//不能以@或者.开始或者结束
		if(atIndex==0||atIndex==textLen||dotLastIndex==0||dotLastIndex==textLen){
			return false;
		}
		//@要在最后一个.之前
		if(atIndex>dotLastIndex){
			return false;
		}
		return true;
	}
}
