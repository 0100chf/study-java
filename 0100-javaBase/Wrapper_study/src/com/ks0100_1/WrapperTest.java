package com.ks0100_1;

/**
 * 代码不需要运行，直接按顺序讲下来
 * 基本数据类型和包装类的转换
 * 自动装箱和自动拆箱
 *
 */
public class WrapperTest {

	public static void main(String[] args) {
		//声明一个boolean基本类型
		boolean b=true;
		//通过构造方法把基本类型变量变成包装类对象
		Boolean bObject=new Boolean(b);
		Boolean bObject2=Boolean.valueOf(b);
		
		int i=5;
		Integer iObject=new Integer(i);
		Integer iObject2=Integer.valueOf(i);
		
		//从包装类对象里的取出基本类型变量
		boolean b2=bObject.booleanValue();
		int i2=iObject.intValue();
		
		 
		//自动装箱和拆箱
		Integer i2Object=5;//自动装箱,把基本类型的变量直接赋值给对应的包装类
		Object boolObject=true;//自动装箱,把基本类型的变量直接赋值给Object类
		
		int i3=i2Object;//自动拆箱,把包装类对象赋值给对应的基本类型变量
		int i4=new Integer(4);//自动拆箱
		int i5=new Integer(5);//自动拆箱
		boolean b3=new Boolean(false);//自动拆箱
		boolean b4=Boolean.valueOf(true);//自动拆箱
		
		if(boolObject instanceof Boolean){
			System.out.println("boolObject is Boolean");
			//先把Object对象强制类型转换为Boolean类型，再赋给boolean变量
			boolean b5=(Boolean)boolObject;
		}
		
		
	}

}
