package com.ks0100_1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTest {

	public static void main(String[] args) {
		//.匹配任何单个字符
		System.out.println("**********b.g 可以匹配bg中间是1个字符的字符串 ************");
		Pattern p = Pattern.compile("b.g");// 定义一个Pattern编译正则表达式的对象p
		Matcher m = p.matcher("b1g");// 定义Matcher 对象m来匹配
		
		boolean b = m.matches();// 判断匹配结果
		System.out.println("b.g 和 b1g 匹配：" +  b);
		System.out.println("b.g 和 bug 匹配：" +  Pattern.matches("b.g", "bug"));// 以上三步可以简化为一步用Pattern.matches(...)方法
		System.out.println("b.g 和 b g 匹配：" +  Pattern.matches("b.g", "b g"));
		System.out.println("b.g 和 b你g 匹配：" +  Pattern.matches("b.g", "b你g"));
		System.out.println("b.g 和 buug 匹配：" +  Pattern.matches("b.g", "buug"));
		
		//$匹配行结束
		System.out.println("**********0100$ 可以匹配 末尾字符必须是0100的字符串************");
		Pattern p1 = Pattern.compile("0100$");
		Matcher m1 = p1.matcher("昆山0100");
		System.out.println("用find()方法部分匹配  0100$ 和 昆山0100 匹配：" + m1.find());
		System.out.println("用matches()方法完全匹配  0100$ 和 昆山0100 匹配：" + m1.matches());
		System.out.println("0100$ 和 I Like ks0100 匹配：" + p1.matcher("I Like ks0100").find());
		System.out.println("0100$ 和 I Like ks0100  匹配：" + p1.matcher("I Like ks0100 ").find());//0100后面有空格
		
		//^匹配一行的开始
		System.out.println("**********^昆山 可以匹配 开头字符必须是昆山的字符串************");
		Pattern p2 = Pattern.compile("^昆山");
		System.out.println("^昆山  和 昆山0100  匹配：" + p2.matcher("昆山0100").find());
		System.out.println("^昆山  和 我爱昆山  匹配：" + p2.matcher("我爱昆山").find());
		System.out.println("^昆山  和  昆山  匹配：" + p2.matcher(" 昆山").find());//昆山前面有空格
		
		// *匹配0至多个在它之前的字符。
		System.out.println("**********b*g 可以匹配，g或者g前面都是b的字符************");
		System.out.println("b*g 和 bbbbbg 匹配：" + Pattern.matches("b*g", "bbbbbg"));
		System.out.println("b*g 和 bbbbb1g 匹配：" + Pattern.matches("b*g", "bbbbb1g"));
		System.out.println("b*g 和 badbg 匹配：" + Pattern.matches("b*g", "badbg"));
		System.out.println("b*g 和 bug 匹配：" + Pattern.matches("b*g", "bug"));
		System.out.println("b*g 和 bg 匹配：" + Pattern.matches("b*g", "bg"));
		System.out.println("b*g 和 g 匹配：" + Pattern.matches("b*g", "g"));
		

		//\转义符，用来将元字符当作普通字符来进行匹配
		/*
		 * 50*\\$ 里左边\是java字符串的转义字符，"\\"在java字符串里表示一个\字符；
		 * $是个元字符，要加转义字符\才变成普通字符
		 * 50*\\$这个表达式的意思是5开头，0有零到多个，以$为结尾
		 * 
		 */
		System.out.println("**********50*\\$ 可以匹配50$或者5000$这样的字符************");
		System.out.println("50*\\$ 和 500$  匹配：" + Pattern.matches("50*\\$", "500$"));
		System.out.println("50*\\$ 和 500$  匹配：" + Pattern.matches("50*\\$", "50$"));
		
		//[]匹配括号中的任何一个字符
		System.out.println("**********b[aiu]g  只能匹配bg中间是aiu这三个字符之一的字符串************");
		System.out.println("b[aiu]g 和 big 匹配：" + Pattern.matches("b[aiu]g", "big"));
		System.out.println("b[aiu]g 和 bag 匹配：" + Pattern.matches("b[aiu]g", "bag"));
		System.out.println("b[aiu]g 和 bug 匹配：" + Pattern.matches("b[aiu]g", "bug"));
		System.out.println("b[aiu]g 和 baiug 匹配：" + Pattern.matches("b[aiu]g", "baiug"));
		System.out.println("b[aiu]g 和 baag 匹配：" + Pattern.matches("b[aiu]g", "baag"));
		System.out.println("b[aiu]g 和 bags 匹配：" + Pattern.matches("b[aiu]g", "bags"));
		Pattern p3 = Pattern.compile("b[aiu]g");
		System.out.println("b[aiu]g 和 bags 用find方法匹配：" + p3.matcher("bags").find());
		
		//-在[]中指定字符的区间，按照ASCII码排序
		System.out.println("**********b[0-9]g  能匹配bg中间是1个数字的字符串************");
		System.out.println("b[0-9]g 和 b1g 匹配：" + Pattern.matches("b[0-9]g", "b1g"));
		System.out.println("b[0-9]g 和 b9g 匹配：" + Pattern.matches("b[0-9]g", "b9g"));
		System.out.println("b[0-9]g 和 bag 匹配：" + Pattern.matches("b[0-9]g", "bag"));
		System.out.println("b[0-9]g 和 b19g 匹配：" + Pattern.matches("b[0-9]g", "b19g"));
		
		System.out.println("**********b[a-zA-Z]g  能匹配bg中间是1个英文字母的字符串************");
		System.out.println("b[a-zA-Z]g 和 bsg 匹配：" + Pattern.matches("b[a-zA-Z]g", "bsg"));
		System.out.println("b[a-zA-Z]g 和 bAg 匹配：" + Pattern.matches("b[a-zA-Z]g", "bAg"));
		System.out.println("b[a-zA-Z]g 和 b1g 匹配：" + Pattern.matches("b[a-zA-Z]g", "b1g"));
		
		//^在[]中表示排除括号里面的字符串
		System.out.println("**********[^asd]g  能匹配排除g前面的字母是asd的字符串************");
		System.out.println("[^asd]g 和 eg 匹配：" + Pattern.matches("[^asd]g", "eg"));
		System.out.println("[^asd]g 和 ag 匹配：" + Pattern.matches("[^asd]g", "ag"));
		
		//^和-在[]可以配合使用，表示排除一定范围的字符串
		System.out.println("**********b[^0-9abcA-Z]g  能匹配排除bg中间是数字和abc和大写字母的字符串************");
		System.out.println("b[^0-9abcA-Z]g 和 bxg 匹配：" + Pattern.matches("b[^0-9abcA-Z]g", "bxg"));
		System.out.println("b[^0-9abcA-Z]g 和 b0g 匹配：" + Pattern.matches("b[^0-9abcA-Z]g", "b0g"));
		System.out.println("b[^0-9abcA-Z]g 和 bDg 匹配：" + Pattern.matches("b[^0-9abcA-Z]g", "bDg"));
		System.out.println("b[^0-9abcA-Z]g 和 bag 匹配：" + Pattern.matches("b[^0-9abcA-Z]g", "bag"));
		
		//()里面的表达式定义为组，将匹配这个表达式的字符保存到临时区域，在字符串提取的时候非常有用。下面会和其他元字符一起演示
		//|将两个匹配条件进行逻辑'或'运算
		System.out.println("**********z|food 只能和z或者food匹配**********");
		System.out.println("z|food 和 z 匹配："+Pattern.matches("z|food", "z"));
		System.out.println("z|food 和 food 匹配："+Pattern.matches("z|food", "food"));
		System.out.println("z|food 和 fod 匹配："+Pattern.matches("z|food", "fod"));
		System.out.println("z|food 和 zood 匹配："+Pattern.matches("z|food", "zood"));
		
		System.out.println("**********(z|f)ood 能和zood或者food匹配**********");
		System.out.println("(z|f)ood 和 zood 匹配："+Pattern.matches("(z|f)ood", "zood"));
		System.out.println("(z|f)ood 和 food 匹配："+Pattern.matches("(z|f)ood", "food"));
		System.out.println("(z|f)ood 和 ood 匹配："+Pattern.matches("(z|f)ood", "ood"));
		System.out.println("(z|f)ood 和 z 匹配："+Pattern.matches("(z|f)ood", "z"));
		
		System.out.println("**********|用在[]里面就是普通字符了**********");
		System.out.println("[z|f]ood 和 |ood 匹配："+Pattern.matches("[z|f]ood", "|ood"));
		
		System.out.println("********** ^from|subject|date: 与 ^(from|subject|date): 之间的区别 **********");
		Pattern p4 = Pattern.compile("^from|subject|date:");
		System.out.println("^from|subject|date: 匹配 from123:"+p4.matcher("from123").find());
		System.out.println("^from|subject|date: 匹配 subject:"+p4.matcher("subject").matches());
		System.out.println("^from|subject|date: 匹配 date123:"+p4.matcher("date123").matches());
		
		Pattern p5 = Pattern.compile("^(from|subject|date):");
		System.out.println("^(from|subject|date): 匹配 from123:"+p5.matcher("from123").find());
		System.out.println("^(from|subject|date): 匹配 subject:"+p5.matcher("subject").find());
		System.out.println("^(from|subject|date): 匹配 date123:"+p5.matcher("date123").find());
		
		//+ 匹配前面的子表达式一次或多次
		System.out.println("**********0100+ 能匹配末尾是任意多个0的字符串**********");
		System.out.println("010+ 和 0100 匹配："+Pattern.matches("010+", "0100"));
		System.out.println("010+ 和 0100000 匹配："+Pattern.matches("010+", "0100000"));
		System.out.println("010+ 和 010 匹配："+Pattern.matches("010+", "010"));
		
		
		//?匹配前面的子表达式零次或一次，表示可选项
		System.out.println("**********colou?r 可以匹配colour或color的字符串,那个u可以省略**********");
		System.out.println("colou?r 和 colour 匹配："+Pattern.matches("colou?r", "colour"));
		System.out.println("colou?r 和 color 匹配："+Pattern.matches("colou?r", "color"));
		
		System.out.println("**********4(th)? 同 4th|4 只能匹配4th和4**********");
		System.out.println("4(th)? 和 4 匹配："+Pattern.matches("4(th)?", "4"));
		System.out.println("4(th)? 和 4th匹配："+Pattern.matches("4(th)?", "4th"));
		
		/*
		 * 总结一下
		 * *前面字符可以出现0次或出现无数次     
		 * ?前面字符可以出现0次或1次
		 * +前面字符至少要出现1次，可以出现无数次   
		 * 
		 */
		System.out.println("*********区别* ? + ***************");
		System.out.println("*前面字符可以出现0次或出现无数次");
		System.out.println("?前面字符可以出现0次或1次");
		System.out.println("+前面字符至少要出现1次，可以出现无数次");
		
		System.out.println("b* 和 b 匹配：" + Pattern.matches("b*", "b"));
		System.out.println("b* 和  匹配：" + Pattern.matches("b*", ""));
		System.out.println("b* 和 bb 匹配：" + Pattern.matches("b*", "bb"));
		System.out.println("b* 和 bbb 匹配：" + Pattern.matches("b*", "bbb"));
		System.out.println("b? 和 b 匹配：" + Pattern.matches("b?", "b"));
		System.out.println("b? 和 匹配：" + Pattern.matches("b?", ""));
		System.out.println("b? 和 bb匹配：" + Pattern.matches("b?", "bb"));
		System.out.println("b+ 和 匹配：" + Pattern.matches("b+", ""));
		System.out.println("b+ 和 b匹配：" + Pattern.matches("b+", "b"));
		System.out.println("b+ 和 bb匹配：" + Pattern.matches("b+", "bb"));
		//{n}匹配确定的n次
		System.out.println("**********se{2}d 只能匹配两个e**********");	
		System.out.println("se{2}d 和 sed 匹配："+Pattern.matches("se{2}d", "sed"));
		System.out.println("se{2}d 和 seed 匹配："+Pattern.matches("se{2}d", "seed"));
		System.out.println("se{2}d 和 seeed 匹配："+Pattern.matches("se{2}d", "seeed"));
		
		//{n,}至少匹配n次
		System.out.println("**********se{2,}d 能匹配大于等于2的e**********");	
		System.out.println("se{2,}d 和 sed 匹配："+Pattern.matches("se{2,}d", "sed"));
		System.out.println("se{2,}d 和 seed 匹配："+Pattern.matches("se{2,}d", "seed"));
		System.out.println("se{2,}d 和 seeed 匹配："+Pattern.matches("se{2,}d", "seeed"));
		
		//{n,m}最少匹配n次最多匹配m次
		System.out.println("**********se{2,4}d 能匹配从2到4的e**********");	
		System.out.println("se{2,4}d 和 sed 匹配："+Pattern.matches("se{2,4}d", "sed"));
		System.out.println("se{2,4}d 和 seed 匹配："+Pattern.matches("se{2,4}d", "seed"));
		System.out.println("se{2,4}d 和 seeed 匹配："+Pattern.matches("se{2,4}d", "seeed"));
		System.out.println("se{2,4}d 和 seeeed 匹配："+Pattern.matches("se{2,4}d", "seeeed"));
		System.out.println("se{2,4}d 和 seeeeed 匹配："+Pattern.matches("se{2,4}d", "seeeeed"));
		
		// \t 制表符，等同于\u0009
		// \n 换行符，等同于\u000A
		// \d 代表一个数字，等同于[0-9]
		// \D 代表非数字，等同于[^0-9]
		// \s 代表换行符，Tab等空白字符
		// \S 代表非空白字符
		// \w 字母字符，等同于[a-zA-Z0-9]
		// \W 非字母字符，等同于[^\w]
		System.out.println("**********简写的表达式**********");	
		System.out.println("b\\tg 和 b	g 匹配："+Pattern.matches("b\tg", "b	g"));
		System.out.println("b\\u0009g 和 b	g 匹配："+Pattern.matches("b\u0009g", "b	g"));
		System.out.println("123\\n 和 123\n 匹配："+Pattern.matches("123\n", "123\n"));
		System.out.println("0\\d00 和 0100匹配："+Pattern.matches("0\\d00", "0100"));
		System.out.println("0\\d00 和 0L00匹配："+Pattern.matches("0\\d00", "0L00"));
		System.out.println("0\\D00 和 0L00匹配："+Pattern.matches("0\\D00", "0L00"));
		System.out.println("b\\sg 和 b g 匹配："+Pattern.matches("b\\sg", "b g"));
		System.out.println("b\\Sg 和 b g 匹配："+Pattern.matches("b\\Sg", "b g"));
		System.out.println("b\\Sg 和 bwg 匹配："+Pattern.matches("b\\Sg", "bwg"));
		System.out.println("b\\wg 和 bag 匹配："+Pattern.matches("b\\wg", "bag"));
		System.out.println("b\\wg 和 bSg 匹配："+Pattern.matches("b\\wg", "bSg"));
		System.out.println("b\\wg 和 b8g 匹配："+Pattern.matches("b\\wg", "b8g"));
		System.out.println("b\\wg 和 b%g 匹配："+Pattern.matches("b\\wg", "b%g"));
		System.out.println("b\\Wg 和 b%g 匹配："+Pattern.matches("b\\Wg", "b%g"));
		
		//匹配任何字符
		System.out.println("**********匹配任何字符**********");
		System.out.println(".*匹配字符串 Ada：" + Pattern.matches(".*", "Ada"));
		System.out.println(".*匹配字符串 .你%3$Ada\n：" + Pattern.matches(".*", ".你%3$Ada\n"));//.*不能匹配\n
		System.out.println(".+匹配字符串 .你%3$Ada	：" + Pattern.matches(".+", ".你%3$Ada	"));
		System.out.println(".+匹配字符串 s：" + Pattern.matches(".+", "s"));
		System.out.println(".+匹配字符串 .你%3$Ada\n：" + Pattern.matches(".+", ".你%3$Ada\n"));//.+不能匹配\n
		System.out.println("[\\s|\\S]*匹配字符串 .你%3$Ada\n：" + Pattern.matches("[\\s|\\S]*", ".你%3$Ada\n"));
	}

}
