package com.ks0100_3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//这个注解只能在 类、接口(包括注解类型) 或enum上声明使用
@Target(ElementType.TYPE)
public @interface ClassTag {

}
