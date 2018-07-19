package com.ks0100_1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTest2 {

	public static void main(String[] args) {
		System.out.println("第一个方法，提取文件名-----------");
		test1("c:/dir1/dir2/name.txt");
		
		System.out.println("第二个方法，group的用法-----------");
		test2();
		
		System.out.println("第三个方法，验证邮政编码，6位数字即可-----------");
		System.out.println("100830是否邮政编码:"+Pattern.matches("[0-9]{6}", "100830"));
		System.out.println("100830是否邮政编码:"+Pattern.matches("\\d{6}", "100830"));
		System.out.println("10083a是否邮政编码:"+Pattern.matches("\\d{6}", "10083a"));
		
		System.out.println("第四个方法，验证国内电话号码，数字和-即可-----------");
		/*
		 * 如果有-，那么-前面是0开头，3位或4位数字，如010,0510；-后面是数字
		 * 如果没有-,后面是数字
		 */
		String regex="(0[0-9]{2,3}\\-)?[0-9]+";
		System.out.println("0510-95555是否电话号码:"+Pattern.matches(regex, "0512-95555"));
		System.out.println("051095555是否电话号码:"+Pattern.matches(regex, "051095555"));
		System.out.println("010-1234是否电话号码:"+Pattern.matches(regex, "010-1234"));
		System.out.println("05122-1234是否电话号码:"+Pattern.matches(regex, "05122-1234"));
		System.out.println("95555是否电话号码:"+Pattern.matches(regex, "95555"));
		System.out.println("1234-1234是否电话号码:"+Pattern.matches(regex, "12345-1234"));
		System.out.println("12345-1234a是否电话号码:"+Pattern.matches(regex, "12345-1234a"));
		
		System.out.println("第五个方法，提取日期-----------");
		test3("June 26, 1951");
		
		System.out.println("第六个方法，字符替换-----------");
		test4();
		
		System.out.println("第七个方法，验证身份证号码,15位数字和18位数字即可-----------");
		String regex2="\\d{15}|\\d{18}";//
		System.out.println("123456789123456789是否身份证号码:"+Pattern.matches(regex2, "123456789123456789"));
		System.out.println("123456789123456是否身份证号码:"+Pattern.matches(regex2, "123456789123456"));
		System.out.println("123456789123456aaa是否身份证号码:"+Pattern.matches(regex2, "123456789123456aaa"));
		
		System.out.println("第八个方法，提取中文-----------");
		test5("welcome to 中国昆山0100 java 培训班,Thanks！");
		
		System.out.println("第九个方法，提取中文-----------");
		test6("email@163.com");
		test6("email@qq.com");
		test6("www.163.com");
		
		System.out.println("第十个方法，提取url的协议，主机，和路径-----------");
		test7("ftp://www.ftp.com/incoming/movie.rm");
		test7("http://www.163.com/index.jsp?uid=123");
	}

	/*
	 * 提取文件名
	 */
	public static void test1(String path){
		/*
		 * 正则表达式说明：
		 * .+代表任意字符，不包括\n
		 * 被匹配的字符串以任意字符序列开始，后边紧跟着字符"/",最后以任意字符序列结尾。
		 * ()代表分组操作，这里就是把文件名作为分组，匹配完毕就可以通过Matcher类的group方法取到分组
		 * 算法是这样，从左边开始往右找，找到最后一个/,以最后一个/为界，分为两部分c:/dir1/dir2/和name.txt
		 * (.+)里面是子表达式，代表name.txt，所以m.group(1)代表name.txt
		 * 
		 */
		System.out.println("从["+path+"]中提取文件名:");
		String regex=".+/(.+)$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(path);
		if(!m.find()){
			System.out.println("文件格式错误!");
			return;
		}
		//注意group的索引是从1开始而不是0
		System.out.println(m.group(1));
		//System.out.println(m.group());
	}
	
	/*
	 * group的用法
	 */
	public static void test2(){
		Pattern p = Pattern.compile("(\\d+,)(\\d+)");
		String s = "123,456-34,345";
		Matcher m = p.matcher(s);
		while (m.find()) {
			System.out.println("m.group():" + m.group()); // 打印一个大组
			System.out.println("m.group(1):" + m.group(1)); // 打印组1
			System.out.println("m.group(2):" + m.group(2)); // 打印组2
			System.out.println();
		}
		System.out.println("捕获个数:groupCount()=" + m.groupCount());
	}
	
	/*
	 * 在日期中提取月份
	 */
	public static void test3(String date){
		System.out.println("从日期["+date+"]中提取月份");
		/*
		 * ([a-zA-Z]+)任意英文字母，并且放在group里
		 * \\s+ 1到多个空格或tab
		 * [0-9]{1,2}, 表示日期,1个数字或者两个数字，末尾用,
		 * \\s*表示0到多次  空格或tab
		 * [0-9]{4} 表示年份，4个数字
		 * 最后按照括号提取月份
		 */
		String regex="([a-zA-Z]+)\\s+[0-9]{1,2},\\s*[0-9]{4}";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(date);
		if(!m.find()){
			System.out.println("日期格式错误!");
			return;
		}
		System.out.println(m.group(1));
	}
	
	/*
	 * 把字符串替换
	 * 替换所有的a为A
	 */
	public static void test4(){
		String regex="a+";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher("okaaaa Let me see asdsadaaa23121oa");
		String s=m.replaceAll("A");//注意Matcher类的replaceAll()方法
		System.out.println(s);
	}
	
	/*
	 * 中文提取
	 */
	public static void test5(String str){
		String regex="[\\u4E00-\\u9FFF]+";
		Pattern p=Pattern.compile(regex);
		Matcher matcher=p.matcher(str);
		StringBuffer sb=new StringBuffer();
		while(matcher.find()){
			sb.append(matcher.group());
			//System.out.println(matcher.group());
		}
		System.out.println(sb);
	}
	/*
	 * 验证email
	 */
	public static void test6(String email){
		//email格式: 字母数字@字母数字.字母
		String regex="[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]+";
		Pattern p=Pattern.compile(regex);
		Matcher matcher=p.matcher(email);
		if(matcher.matches()){
			System.out.println(email+"是合法的email地址");
		}else{
			System.out.println(email+"不是合法的email地址");
		}
	}
	/*
	 * 从url中提取协议、主机和路径
	 */
	public static void test7(String url){
		/*第二个()前表示在://之前的字母，如ftp://,http:// 中ftp和http是协议
		 * 第二个()内表示从://开始起 不包括/和:的字符，一直到下一个/前，就是主机
		 * 第三个()内表示，主机之后的字符串
		*/
		String regex="([a-zA-z]+)://([^/:]+)([^#]*)";
		Pattern p=Pattern.compile(regex);
		Matcher matcher=p.matcher(url);
		if(matcher.find()){
			System.out.println("协议是:"+matcher.group(1));
			System.out.println("主机是:"+matcher.group(2));
			System.out.println("路径是:"+matcher.group(3));
		}else{
			System.out.println(url+"输入格式错误！");
		}
	}
	
}





