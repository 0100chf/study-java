package com.ks0100_3;

/*
 * StringBuilder的成员方法
 */
public class StringBuilderTest2 {

	public static void main(String[] args) {

		// 创建字符串缓冲区对象
		StringBuilder sb = new StringBuilder("hellotrue1234.56hellotrue1234.56");
		System.out.println("sb:" + sb);
		System.out.println("------------开始做插入操作------------");
		System.out.println("用insert方法插入world,从索引值5开始: ");
		sb.insert(5, "world");
		System.out.println("sb:" + sb);

		System.out.println("------------开始做删除操作------------");
		// public StringBuffer deleteCharAt(int index):删除指定位置的字符，并返回本身
		System.out.println("删除第二个字符:" + sb.deleteCharAt(1));
		// public StringBuffer delete(int start,int
		// end):删除从指定位置开始指定位置结束的内容，并返回本身
		System.out.println("删除一段字符:" + sb.delete(4, 9));
		System.out.println("删除所有的数据:" + sb.delete(0, sb.length()));

		System.out.println("------------开始做替换操作------------");

		sb.append("hello");
		sb.append("world");
		sb.append("java");
		System.out.println("sb:" + sb);
		// public StringBuffer replace(int start,int end,String str):从start开始到end用str替换
		System.out.println("要把\"world\"这个数据替换为\"节日快乐\":");
		System.out.println("sb:" + sb.replace(5, 10, "节日快乐"));
		System.out.println("------------把字符串反转------------");
		sb.reverse();
		System.out.println("sb:" + sb);

		System.out.println("------------开始做截取字符串操作------------");

		// 截取功能
		// public String substring(int start)
		String s = sb.substring(5);
		System.out.println("s:" + s);
		System.out.println("sb:" + sb);

		// public String substring(int start,int end)
		String ss = sb.substring(5, 10);
		System.out.println("ss:" + ss);
		System.out.println("sb:" + sb);
	}

}
