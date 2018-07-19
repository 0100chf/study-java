package com.ks0100_1;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionTest5 {

	public static void main(String[] args) {
		String s = "2014-11-20";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d = sdf.parse(s); // 创建了一个ParseException对象，然后抛出去，和catch里面进行匹配
			System.out.println(d);
		} catch (ParseException e) { // ParseException e = new ParseException();
			// ParseException
			 e.printStackTrace();

			// getMessage()
			 System.out.println("e.getMessage():"+e.getMessage());

			// toString()
			System.out.println("e.toString():"+e.toString());
			
			//try catch可以嵌套
			try{
				e.printStackTrace(new PrintStream("error.log"));//把错误保存在日志文件里面，见项目目录下error.log
			}catch(FileNotFoundException ex){
				//如果new PrintStream(...)方法有错，还是要处理该异常，这就是checked异常
				//checked异常强制去编写catch方法，是不是很繁琐？
				ex.printStackTrace();
			}
		}

		System.out.println("over");
	}

}
