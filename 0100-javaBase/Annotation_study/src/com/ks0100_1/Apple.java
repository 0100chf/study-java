package com.ks0100_1;

import java.util.ArrayList;
import java.util.List;

/*
 @Override：限定重写父类方法，用来指定方法重写的，它可以强制一个子类必须覆盖父类的方法。
           只能作用于方法。

@Deprecated：标示已过时。 写代码调用AIP的时候，不要去调用有@Deprecated的方法，通常在IO操作的时候，
            有人会犯这个错，虽然代码都能编译通过正常运行，但是之所以不能调用有@Deprecated的方法，
            一个是该方法往往和具体环境有关系，有可能遇到运行时在一些特殊环境下会出错的。
	二是这个方法，API推出以后可能可能没有及时修正，先标记一下@Deprecated，
            在以后版本很有可能 就删除掉，所以大家不要用。

@SuppressWarnings：抑制编译器警告，大家可以用eclipse提示

 */
class Fruit{
	public void info(){
		System.out.println("水果的方法");
	}
}
public class Apple extends Fruit{
	
	//有的时候子类覆盖父类的方法容易写错，运行时才发现，那么加上这个@Override这个注解可以让编译时检查
	@Override
	public void info(){
		System.out.println("苹果的方法，覆盖水果");
	}
	
	//以下代码错误，覆盖父类的方法签名写错了
	//@Override
	//public void info1(){}
	
	//定义方法过时，eclipse很好，直接把方法标识中划线，表示不推荐使用改方法
	@Deprecated
	public void info2(){
		
	}
	
	@SuppressWarnings({ "unused", "rawtypes" })
	public void info3(){
		List a=new ArrayList();
	}

	public static void main(String[] args) {

	}
}
