[TOC]



## 目标

- [x] 多ORM：jdbctemplate
- [x] ORM：jpa
- [x] ORM：mybatis
- [x] mybatis插件1 pagehelper插件、通用mapper插件
- [ ] mybatis插件2 mybatisplus（暂停） 
- [ ] 多数据源
- [ ] 事务
- [ ] Flyway数据库版本控制器？
- [ ] Restful
- [ ] Thymeleaf
- [ ] Freemarker
- [ ] 整合swagger2
- [ ] 异常统一处理，包含接口异常和页面异常
- [ ] 整合mock测试，接口测试和页面测试?
- [ ] 整合代码扫描 sonar?
- [ ] 整合多环境及打包？
- [ ] 连接缓存 redis
- [ ] 连接缓存ehcache
- [ ] 连接Mongodb？
- [ ] LDAP？
- [ ] 日志
- [ ] 集成shiro
- [ ] 集成JWT
- [ ] 异步调用、多线程
- [ ] 定时任务?
- [ ] 邮件发送?
- [ ] 消息服务?
- [ ] 使用Spring StateMachine框架实现状态机
- [ ] 后台运行
- [ ] 自定义Banner

## 关系型数据库访问

### Jdbctemplate

#### 配置

Maven

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
<!-- 可以省略 其他orm框架也需要，如 mybatis -->
<dependency>
    <groupId>mysql</groupId>
<artifactId>mysql-connector-java</artifactId>
<!—可以去掉-->
    <version>5.1.21</version>
</dependency>
```

application.properties配置

```properties
#MySQL配置
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/springboot-all?useUnicode=true&autoReconnect=true&failOverReadOnly=false&zeroDateTimeBehavior=round&autoReconnect=true
spring.datasource.username=chf
spring.datasource.password=chfs
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```

#### 在service类写sql

调用jdbcTemplate类的方法

> 参考 org.spring.springboot.orm.jdbctemplate.UserServiceImpl

调用RowMapper实现类来映射实体

> 参考org.spring.springboot.orm.jdbctemplate.UserRowMapper
>
> UserServiceImpl 的方法 findById(int id)
>
> UserServiceImpl 的方法 findAll()

调用BeanPropertyRowMapper来映射实体

> 参考UserServiceImpl 的方法 findAll2()

采用jdbcTemplate.batchUpdate()来批量插入

> 参考UserServiceImpl 的方法 createUserByBatch(int count)

继承BatchSqlUpdate类来批量插入

> org.spring.springboot.orm.jdbctemplate.BatchInsert
>
> 参考UserServiceImpl 的方法 createUserByBatch2()

#### 测试

> org.spring.springboot.jdbctemplate.JdbctemplateTests

### Jpa

使用Jpa可以大大节省代码的开发量，用接口的方法findByXXX()，就可以做查询，jpa接口实现了泛型的开箱即用的增删改查方法，还提供分页查询。如果要用sql，用@Query、@Modifying。但是写SQL不如Mybatis。

#### 配置

Maven

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<!-- mysql-connector-java 参考Jdbctemplate -->
```

application.properties配置

```properties
#MySQL配置 参考Jdbctemplate
spring.jpa.properties.hibernate.hbm2ddl.auto=update
#create：每次加载hibernate时都会删除上一次的生成的表，然后根据你的model类再重新来生成新表，哪怕两次没有任何改变也要这样执行，这就是导致数据库表数据丢失的一个重要原因。
#create-drop：每次加载hibernate时根据model类生成表，但是sessionFactory一关闭,表就自动删除。
#update：最常用的属性，第一次加载hibernate时根据model类会自动建立起表的结构（前提是先建立好数据库），以后加载hibernate时根据model类自动更新表结构，即使表结构改变了但表中的行仍然存在不会删除以前的行。要注意的是当部署到服务器后，表结构是不会被马上建立起来的，是要等应用第一次运行起来后才会。
#validate：每次加载hibernate时，验证创建数据库表结构，只会和数据库中的表进行比较，不会创建新表，但是会插入新值。
```

#### 基于接口做ORM

##### Repository 接口

	Repository是jpa核心接口，CrudRepository、PagingAndSortingRepository

JpaRepository 都继承该接口做扩展，它可以用findByXXX()方法。可以用@Query写HQL或SQL。

> [findByXXX](https://www.cnblogs.com/BenWong/p/3890012.html)
>
> org.spring.springboot.orm.jpa.UserRepository2

##### CrudRepository接口

	它会自动为域对象提供了开箱即用的十个增删改查方法。

> org.spring.springboot.orm.jpa.UserCrudRepository

##### PagingAndSortingRepository接口

它继承自 CrudRepository 接口，在 CrudRepository 基础上新增了两个与分页有关的方法。

> org.spring.springboot.orm.jpa.UserPagingAndSortingRepository

##### JpaRepository接口

JpaRepository 是继承自 PagingAndSortingRepository 的针对 JPA 技术提供的接口，它在父接口的基础上，提供了其他一些方法，比如 flush()，saveAndFlush()，deleteInBatch() 等。如果有这样的需求，则可以继承该接口。

> org.spring.springboot.orm.jpa.UserJpaRepository

#### 测试

> org.spring.springboot.jpa.JpaTests

### Mybatis

#### mybatis与spring集成的几种方式

使用 MyBatis 的主要 Java 接口就是 SqlSession，会用SqlSessionFactory 对象包含创建 SqlSession 实例，并加载数据库配置文件（如mybatis-config.xml）。但是当 Mybatis 与一些依赖注入框架（如 Spring 或者 Guice）同时使用时，SqlSessions 将被依赖注入框架所创建，所以你不需要使用SqlSessionFactory-Builder 或者 SqlSessionFactory，特别是spring boot更加简单，可以直接在application文件中配置数据库，并用注解方式映射数据库查询。


A. 使用SqlSession读取配置文件mybatis-config.xml，用mapper/*.xml映射数据库字段

  --适合junit测试

B.spring 容器加载 SqlSession，读取配置文件mybatis-config.xml，用mapper/*.xml映射数据库字段

   --适合web项目

C.spring 容器加载 SqlSession，读取配置文件mybatis-config.xml，用注解方式映射数据库字段

   --适合web项目

D.springboot 加载mybatis，在application 文件中配置，用注解方式映射数据库字段。

   <u>如果用application 文件配置就不要配置mybatis-config.xml，会出现配置属性重复错误。</u>

   --适合web项目和测试

E.springboot 加载mybatis，在application 文件中加载mybatis-config.xml，配置文件还写在mybatis-config.xml，用xml 映射数据库字段。application文件只配数据源并加载mybatis-config.xml与mapper/*.xml。

   **--最佳实践。**这样sql不要用字符串拼接。适合web项目，测试。

F.springboot 加载mybatis，在application 文件中加载mybatis-config.xml，配置文件还写在mybatis-config.xml，用注解方式映射数据库字段

   --适合web项目，测试

   <u>注意注解方式映射和xml映射数据库不要混在一起用，会出现取不到数据问题。</u>

G.springboot 加载mybatis，也可以用application文件配置，mapper/*.xml映射数据库字段，不用mybatis-config.xml。
application文件配置的属性参考资料比较少，不推荐。

#### 配置

```xml
<dependency>
	<groupId>org.mybatis.spring.boot</groupId>
	<artifactId>mybatis-spring-boot-starter</artifactId>
	<version>1.1.1</version>
</dependency>
<!--mysql-connector-java 参考Jdbctemplate -->
```

application.properties配置中连接数据库的部分，参考之前。

#### 集成方法D（纯注解）

在interface上加@Mapper即可

```java
import org.apache.ibatis.annotations.*;

@Mapper //容器会加载这种接口，替代原来的xml方式
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

}

```

别忘了在程序入口类Application，加上@MapperScan

```java
@MapperScan("org.spring.springboot.orm.mybatis")
public class Application {

    public static void main(String[] args) {
        // 程序启动入口
    	SpringApplication.run(Application.class,args);
    }
}
```

> [在application.properties设置setting](http://www.mybatis.org/mybatis-3/configuration.html#settings)
>
> org.spring.springboot.orm.mybatis.SysRoleMapper
>
> org.spring.springboot.orm.mybatis.UserMapper

注意junit方法是自动回顾，要提交数据需要

```java
@Test
@Rollback(value=false)//junit默认是回滚的
public void testUserMapper() throws Exception {
   //....写测试方法
}
```

#### 集成方法E（mybatis-config.xml+mapper/*.xml）

在application.properties装载mybatis 的xml文件

```properties
mybatis.config-location=classpath:mybatis-config.xml
mybatis.mapper-locations=classpath:mapper/*.xml
```

mybatis-config.xml文件配置<settings>、<typeAliases>

> mybatis-config.xml

*<u>注意在mybatis-config.xml配置的，就不能在application.properties做配置</u>*

在 写interface，对应的在mapper/*.xml写sql

> SysRoleMapper2.xml
>
> org.spring.springboot.orm.mybatis.SysRoleMapper2

#### 测试

> org.spring.springboot.mybatis.MybatisTests

### mybatis插件1 pagehelper插件、通用mapper插件

#### pagehelper插件

用该插件解决物理分页，分页插件支持任何复杂的单表、多表分页，部分特殊情况请看[重要提示](https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/Important.md)。

> [官网](https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md)

配置

```xml
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper-spring-boot-starter</artifactId>
    <version>最新版本</version>
</dependency>
```

application配置，省略数据源和mybatis配置

用法

```java
PageHelper.startPage(pageNum, pageSize);
//紧跟着的第一个select方法会被分页
List<Country> list = countryMapper. selectAll ();

//后面的不会被分页，除非再次调用PageHelper.startPage
List<Country> list2 = countryMapper. selectAll ();
```

不能的写法

```java
PageHelper.startPage(1, 10);
List<Country> list;
if(param1 != null){
    list = countryMapper.selectIf(param1);
} else {
    list = new ArrayList<Country>();
}
```

应该的写法

```java
List<Country> list;
if(param1 != null){
    PageHelper.startPage(1, 10);
    list = countryMapper.selectIf(param1);
} else {
    list = new ArrayList<Country>();
}
```

> org.spring.springboot.orm.mybatis.PageController
>
> org.spring.springboot.orm.mybatis.pagehelper.PageService

用PageController测试注意

	该工程集成了shiro，所以要在RedisShiroConfig或EhcacheShiroConfig中的shirFilter()方法中加上

```java
filterChainDefinitionMap.put("/pagetest/**", "anon");
```

表示作为shiro的匿名用户，不受角色权限限制。RedisShiroConfig和EhcacheShiroConfig的@Configuration只能在其中的一个类上用，如果用RedisShiroConfig，要安装redis，并且打开redis服务。redis是管理session用的，如果不用redis管，可以把两行代码注释掉：

```java
@Bean
	public DefaultWebSecurityManager securityManager(){
		DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		//如果没有配置redis 可以把下面两行代码注释
		// 自定义session管理 使用redis
		securityManager.setSessionManager(sessionManager());
		// 自定义缓存实现 使用redis
		securityManager.setCacheManager(redisCacheManager());
		return securityManager;
	}
```

测试url用：

http://localhost:8080/pagetest/getList2?pageNum=2&pageSize=6 和
http://localhost:8080/pagetest/getList?pageNum=2&pageSize=6

联表查询分页：

http://localhost:8080/pagetest/getList3?pageNum=1&pageSize=3&poid=po2

#### mapper插件

对每个单表写sql进行CRUD操作太繁琐，出现了通用Mapper来解决这个问题。类似的解决方式，可以用jpa或hibernate的泛型类来解决。

> [官网](https://github.com/abel533/Mapper/wiki/1.integration)

Maven配置

	省略mybatis和mysql驱动配置

```xml
<!--与springboot集成-->
<dependency>
  <groupId>tk.mybatis</groupId>
  <artifactId>mapper-spring-boot-starter</artifactId>
  <version>版本号</version>
</dependency>
```

application配置

```properties
mapper.mappers=tk.mybatis.mapper.common.Mapper,tk.mybatis.mapper.common.Mapper2
mapper.notEmpty=true
```

	由于 Spring Boot 支持 Relax 方式的参数，因此你在配置 notEmpty 时更多的是用 not-empty，也只有在 Spring Boot 中使用的时候参数名不必和配置中的完全一致。

> [官网配置](https://github.com/abel533/Mapper/wiki/3.config)

@MapperScan 注解配置

```java
//可以兼容mybatis的@MapperScan
@tk.mybatis.spring.annotation.MapperScan(basePackages = "org.spring.springboot.orm.mybatis")
```

> org.spring.springboot.Application
>

映射实体类

> org.spring.springboot.orm.mybatis.mapper.MapperCountry
>
> [官网配置](https://github.com/abel533/Mapper/wiki/2.2-mapping)

使用Mapper

> org.spring.springboot.orm.mybatis.mapper.CountryMapper

	一旦继承了Mapper，CountryMapper就能够使用selectOne()、select()、selectAll()等诸多封装的方法。
在这个interface  不但可以直接用注解写sql，还可以在xml写sql，两者可以混合使用。

测试Mapper

> org.spring.springboot.mybatis.MapperTest

mapper和pagehelper联合使用

> org.spring.springboot.orm.mybatis.mapper.CountryService
>
> 测试Controller：org.spring.springboot.orm.mybatis.PageController
>
> PageController注意见上文
>
> 测试URL如下：
>
> http://localhost:8080/pagetest/getCountryList?pageNum=2&pageSize=3
>
> http://localhost:8080/pagetest/getCountryList2?pageNum=2&pageSize=3

使用java.util.UUID生成主键UUID

	实体类用@KeySql

> UUID实现类：org.spring.springboot.orm.mybatis.mapper.genid.UUIdGenId
>
> 实体类:org.spring.springboot.orm.mybatis.mapper.genid.User

用同步的bigint来做UUID

	实体类用@KeySql

> UUID实现类：org.spring.springboot.orm.mybatis.mapper.genid.SimpleGenId
>
> 实体类：org.spring.springboot.orm.mybatis.mapper.genid.User2

测试UUID生成

> org.spring.springboot.mybatis.GenidTest

### mybatis插件2 mybatisplus 




