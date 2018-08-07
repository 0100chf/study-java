# Spring Boot+Shiro+Cache

## 集成shiro管理权限

### pom.xml

```xml
<!--添加shiro依赖 -->
<dependency>
    <groupId>org.apache.shiro</groupId>
    <artifactId>shiro-spring-boot-starter</artifactId>
    <version>1.4.0</version>
</dependency>
```

### shiro config类

参考EhcacheShiroConfig 类和RedisShiroConfig类，打开其中一个类的@Configuration注解，分别用Ehcache或Redis缓存shiro session。特别注意shirFilter()方法，把所有URL拦截，判断登录和权限。注意要把“登录页”和“登录请求”同时设置成“anno”（匿名访问）。注意swagger 2的配置

### Realm类（MyShiroRealm）

- 登录校验

  调用：subject.login(..)方法会被Realm类的doGetAuthenticationInfo(..)方法拦截。参考UserService.loginUser(..)。

- 权限校验

  调用@RequiresPermissions注解的方法或页面标签，都会被Realm类的doGetAuthorizationInfo(..)方法拦截。参考UserInfoController类。

### 用户、角色、权限

参考model包下，这里用了JPA。

注意实体类用lombok的时候不要用@Data注解，会重写toString(..)方法

## shiro的session对象保存在Ehcache或Redis

### 推荐使用Redis

shiro 自带缓存，和Ehcache本质区别不大。而Redis可以做分布式缓存。

Redis采用crazycake jar包做集成，能够把sessionid缓存，还可以重写获取sessionid的方式，适合前后端分离。以及优化Redis读取缓存的次数。而这些Ehcache都还做不到。

### pom.xml文件

网上有很多不好的配置，会导致错误。

注意shiro和Redis集成的时候，会出现jar包冲突

```xml
		<!--添加shiro和redis集成 -->
		<dependency>
    		<groupId>org.crazycake</groupId>
    		<artifactId>shiro-redis</artifactId>
    		 <version>2.8.24</version>
    		 <exclusions>
    		 	<exclusion>
    		 		<artifactId>shiro-core</artifactId>
    		 		<groupId>org.apache.shiro</groupId>
    		 	</exclusion>
    		 </exclusions>
		</dependency>
```

crazycake 这个jar包能够实现把shiro session保存到Redis中

### 用Ehcache保存

- 参考EhcacheShiroConfig类。

  入口看securityManager(..)方法。CacheManager使用的是自己写的类EhcacheShiroManager，它只能把 new SimpleAuthenticationInfo(..)方法的第一个参数，如user对象的toString()方法作为key，而不是subject.getSession().getId()。但是不能把权限，如Realm类中的doGetAuthorizationInfo(..)方法下的authorizationInfo保存在缓存里。

  注意EhcacheShiroConfig类中的@Bean方法的特别配置。

- 使用ehcache-monitor-kit-1.0.3来监控

  在ehcache.xml配置和引用ehcache-probe-1.0.3.jar

- ehcache.xml配置

  SpringBoot默认读取resources/下的该文件， 

### 用Redis保存

- 参考RedisShiroConfig类

  入口看securityManager(..)方法。CacheManager用  crazycake 的。还可以设置sessionManger，参考RedisSessionManager，不但可以保存sessionid，还可以重写获取sessionid方法，便于前后端隔离。并且优化减少频繁读取redis缓存的方式。

- 开启Redis服务，用treeNMS-1.7.2工具来监控

## 良好的代码规范

> [程序员你为什么这么累](https://xwjie.github.io/rule/) 
>
> [晓风轻的Spring开发代码模板](https://github.com/xwjie/PLMCodeTemplate)

### controller 规范

#### 处理APP请求

- ResultBean类

  如果controller是处理APP请求的接口，则统一返回ResultBean类，ResultBean类由data和HttpStatus组成。HttpStatus是传给前端的公共规范编码，如500，404等状态码。而data再封装成ResultStatus。

  <!--这里是对“晓风轻”代码的重要改进，他的代码都是HttpStatus为200下的业务状态码分类，不符合http规范-->

  接口统一返回ResultBean类就可以用AOP统一拦截，提取出异常。

- ResultStatus类

  把ResultBean类中的data又封装成ResultStatus类，这个类又分为data属性、msg和msgCode。

  msgCode把相同的HttpStatus再细分。msg采用了国际化，参考LocalUtil、message.properties和StaticFieldConfig类。

  ResultStatus类不仅仅作为ResultBean的构造方法里参数，也可以在某些场景作为ResponseEntity的构造方法的参数，这样就不走AOP异常处理。参考HomeController类的unlogin(..)方法。

#### 处理WEB请求

- @WebControllerAnno

  在controller方法使用该注解，这样AOP可以拦截，处理异常和统计处理时间。参考WebControllerAOP类。WebController类。

  

#### controller其他规范

- Controller只做参数格式的转换

- 参数不允许出现Request，Response 这些对象
- 不需要打印日志

## service 规范

- 进入方法后，先做数据校验，调用静态工具方法。参考CheckUtil类。
- 在service里面打印日志，具体参考“日志打印”-“日志代码编写要求”

## 异常统一处理

### 异常处理规范

不要在controller、service这些业务代码里面写异常处理，由AOP方式或ExceptionHandler方式统一处理。

### AOP方式拦截异常

分别拦截APP Controller和WEB Controller，参考APPControllerAOP和APPControllerAOP。

为什么不用 ControllerAdvice + ExceptionHandler 来处理异常？ 而最重要的是ExceptionHandler只能处理异常，而我们的AOP除了处理异常，还有一个很重要的作用是打印日志，统计每一个controller方法的耗时，这在实际工作中也非常重要和有用的特性！ 

### ExceptionHandler处理全局异常

404异常，shiro抛出的无权限异常，以及AOP方式拦截不到的异常。参考GlobalExceptionHandler类。

### Shiro的无权限异常

shiro用Filter的方式对URL做统一拦截，所以没法用AOP来拦截，可以自己抛出异常，用GlobalExceptionHandler类来。参考MyShiroRealm类。

## 日志打印

> [晓风轻-日志要求](https://xwjie.github.io/rule/log.html#%E6%97%A5%E5%BF%97%E8%A6%81%E6%B1%82)

### MDC加入和删除

> [log4j MDC用户操作日志追踪配置](https://blog.csdn.net/userwyh/article/details/52862216)

MDC（Mapped Diagnostic Context，映射调试上下文）是 log4j 和 logback 提供的一种方便在多线程条件下记录日志的功能。 每个用户请求，都可以分为多线程，而用了MDC可以区分不同用户所对应的日志 。

我们可以事先把用户的sessionId，登录用户的用户名，访问的城市id，当前访问商户id等信息定义成字段，线程开始时把值放入MDC里面，后续在其他地方就能直接使用，无需再去设置了。

- MDC加入和使用

  登录后加入，参考UserService类loginUser(..)方法。LOG用logback，使用MDC，见logback.xml中%X{user}，user是传入MDC的key。

```java
public static final String KEY_USER = "user";
.......
// 把用户帐号放到log4j，便于日志追踪
MDC.put(KEY_USER, username);
```

```xml
<layout class="ch.qos.logback.classic.PatternLayout">
  			<!--格式化输出：%d表示日期，%X表示MDC定义的KEY，%thread表示线程名，%-5level：级别从左显示5个字符宽度%msg：日志消息，%n是换行符 -->
  			<pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%X{user}] [%thread] %-5level %logger{50} -%msg%n
  			</pattern>
  		</layout>
```

- MDC删除

  登出后删除。

```java
	public Boolean logout(){
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			subject.logout();
			MDC.remove(KEY_USER);
		}
		return new Boolean(true);
	}
```


### LOG配置

springboot本身集成了logback，如果要改成log4j2，要在pom.xml配置，并且注意jar冲突。

log的格式参考logback.xml。

### 日志代码编写要求

- controller不要打印日志、service需要打印日志。

- 修改（包括新增、删除）操作必须打印日志 。

- 查询不需要，如果数据量大需要。

- 条件分支必须打印条件值，重要参数必须打印 

  尤其是分支条件的参数，打印后就不用分析和猜测走那个分支了，很重要！如下面代码里面的userType，一定要打印值，因为他决定了代码走那个分支。 

```java
public boolean delete(long id){
    int userType=getCurrentUserType();
    //校验通过后打印重要的日志
  //需要做分支判断，userType必须打印
logger.info("delete config， id:"+id+",userType:"+userType);
    boolean result=false;
    if(userType==1){
      //做这些事情
    }else{
      //做那些事情
    }
    //本方法是delete操作，所以把参数和结果打印出来
logger.info("delete config success,id:"+id+",result:"+result);
   return result;//示例代码
}
```

## 集成swagger2

配置参考Swagger2类。Swagger2和shiro集成要考虑URL过滤问题，参考ShiroConfig类的代码，如下：

```java
// 以下4句配置swagger不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/swagger-ui.html", "anon");
    filterChainDefinitionMap.put("/swagger-resources/**", "anon");
    filterChainDefinitionMap.put("/v2/api-docs", "anon");
    filterChainDefinitionMap.put("/webjars/springfox-swagger-ui/**", "anon");
```

## 集成thymeleaf

- 对HTML的格式要求比较严格，否则会出错。

- 要结合nekohtml，否则会出错。

  nekohtml类似HtmlParse

## 其他集成

集成JPA、集成Lombok

## 测试

### 登录页面

|          | web请求       | app请求                            |
| -------- | ------------- | ---------------------------------- |
| 登入页   | /web/to-login | /app/unlogin（返回的是未登录json） |
| 登入请求 | /web/login    | /app/login                         |
| 登出请求 | /web/loginout | /app/loginout                      |

APP测试登录用swagger

http://localhost:8080/swagger-ui.html

### 测试帐号

admin/123456    vip/123456

admin，有查看用户userList和添加用户权限userAdd
http://localhost:8080/userInfo/userList
http://localhost:8080/userInfo/userAdd

vip，有用户删除权限userDel
http://localhost:8080/userInfo/userDel