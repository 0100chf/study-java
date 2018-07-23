package cn.ks0100.common.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 如果controller方法使用了该注解，cn.ks0100.common.aop.WebControllerAOP 就会拦截
 * @author chen haifeng
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebControllerAnno {

}
