package com.ks0100_1;

/*
 * 字符串替换
 */
public class StringTest6 {

	public static void main(String[] args) {
		// 替换功能

		String s1 = "helloworld";
	
		System.out.println("s1:" + s1);
		
		System.out.println("把helloworld中l换成k");
		String s2 = s1.replace('l', 'k');
		System.out.println("s2:" + s2);
		
		System.out.println("把helloworld中owo换成ak47");
		String s3 = s1.replace("owo", "ak47");
		System.out.println("s3:" + s3);
		System.out.println("---------------");

		// 去除字符串两空格
		String s4 = " hello world  ";
		String s5 = s4.trim();
		System.out.println("s4:" + s4 + "---");
		System.out.println("去除字符串两空格");
		System.out.println("s5:" + s5 + "---");
		System.out.println("--------开始比较字符串--------------");
		// 按字典顺序比较两个字符串
		/*
		 * compareTo()的返回值是整型,它是先比较对应字符的大小(ASCII码顺序),
		 * 如果第一个字符和参数的第一个字符不等,结束比较,返回他们之间的差值,
		 * 如果第一个字符和参数的第一个字符相等,则以第二个字符和参数的第二个字符做比较,
		 * 以此类推,直至比较的字符或被比较的字符有一方全比较完,这时就比较字符的长度. 
		 */
		String a1 = "abc"; 
		String a2 = "abcd"; 
		String a3 = "abcdfg"; 
		String a4 = "1bcdfg"; 
		String a5 = "cdfg"; 
		System.out.println( a1.compareTo(a2) ); // -1 (前面相等,a1长度小1) 
		System.out.println( a1.compareTo(a3) ); // -3 (前面相等,a1长度小3) 
		System.out.println( a1.compareTo(a4) ); // 48 ("a"的ASCII码是97,"1"的的ASCII码是49,所以返回48) 
		System.out.println( a1.compareTo(a5) ); // -2 ("a"的ASCII码是97,"c"的ASCII码是99,所以返回-2)
	}

}
