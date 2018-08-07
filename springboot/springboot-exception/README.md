> [程序员你为什么这么累 ](https://xwjie.github.io/rule/)

## 用@RestControllerAdvice处理 全局异常 

（全局异常），如404、403、使用框架参数等错误，GlobalExceptionHandler这个Advice是先捕获异常，如果没有异常，在转给Controller AOP去拦截处理。

## 用AOP的方式来检查controller

这种方法的好处是，不仅仅在异常的时候才进入AOP，可以用该AOP统计Controller执行时间。并且Controller层和service层代码写得非常简洁，不需要写异常捕获和国际化。

两种AOP分别检查app接口controller和页面controller。
页面controller要加自定义的注解@WebControllerAnno才可以识别。

app接口controller因为都返回ResultBean，所以AOP可以拦截。

## Controller和service

controller只做参数格式的转换 ，不需要打印日志 ，controller调用service。业务异常（比如数据校验）都在service层做。而且封装了校验工具CheckUtil中，使得service层代码非常清晰简介。在service里面打印日志 。

## 异常信息反馈

用MessageSource和ThreadLocal来实现国际化。

参考GlobalExceptionHandler

```java
CheckUtil.getResources().getMessage("interface.no.found",null, UserUtil.getLocale())
```

