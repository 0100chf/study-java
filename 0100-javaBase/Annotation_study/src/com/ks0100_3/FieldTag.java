package com.ks0100_3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//这个注解 只能在Field上使用声明使用
@Target(ElementType.FIELD)
public @interface FieldTag {

}
