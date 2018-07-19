package com.ks0100_3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

//只能在方法上使用
@Target(ElementType.METHOD)
public @interface MethodTag {

}
