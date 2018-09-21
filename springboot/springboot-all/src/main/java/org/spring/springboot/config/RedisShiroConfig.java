package org.spring.springboot.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.shiro.MyShiroRealm;
import org.spring.springboot.shiro.RedisSessionManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisShiroConfig {
	private static final Logger logger = LoggerFactory.getLogger(RedisShiroConfig.class);
	
	 
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		
		logger.info("ShiroConfig_redis ShiroConfiguration.shirFilter().....................");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//拦截器.
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
		// 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/pagetest/**", "anon");
		
		/**
		 * 正常登录流程是，先进入controller登录，然后调用subject.login，进入shiro的AuthorizingRealm的拦截方法doGetAuthenticationInfo()
		 * 要把进入登录页的url和登录请求的url都设置成anon（匿名访问），这样请求这两个url就不会执行拦截方法doGetAuthenticationInfo()做校验
		 * 否则会先进入shiro的拦截器doGetAuthenticationInfo，然后进入controller登录
		 */
		filterChainDefinitionMap.put("/web/to-login", "anon");//进入web登入页
		filterChainDefinitionMap.put("/app/unlogin", "anon");//app接口请求，未登录返回的接送接口
		filterChainDefinitionMap.put("/app/login", "anon"); //app登入请求，开始校验
		filterChainDefinitionMap.put("/web/login", "anon"); //web登入请求，开始校验
		
		// 以下4句配置swagger不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/swagger-ui.html", "anon");
       filterChainDefinitionMap.put("/swagger-resources/**", "anon");
       filterChainDefinitionMap.put("/v2/api-docs", "anon");
       filterChainDefinitionMap.put("/webjars/springfox-swagger-ui/**", "anon");
       
		//配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
		filterChainDefinitionMap.put("/web/loginout", "logout");
		filterChainDefinitionMap.put("/app/loginout", "logout");
		//<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
		//<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
		filterChainDefinitionMap.put("/**", "authc");
		
		// 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		//这里是登录进入校验用户名密码的controller，会被MyShiroRealm.doGetAuthenticationInfo()拦截
		/**
		 * 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
		 * 这个设置的真正含义是：如果发现请求没有登录，应该转到url（指向登录页），让用户继续登录。
		 * 有些人会把进入登录页如url1，登入请求url2都设置成一致，区别在于url1是get，而url2是post，这容易误解
		 */
		//shiroFilterFactoryBean.setLoginUrl("/web/to-login");//web请求，未登录转到的页面，两者取一
		shiroFilterFactoryBean.setLoginUrl("/app/unlogin");//app接口请求，未登录返回的接送接口，两者取一
		// 登录成功后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("/index");//适用于web请求

		//未授权界面;
		shiroFilterFactoryBean.setUnauthorizedUrl("/403");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}

	/**
	 * 凭证匹配器
	 * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
	 * ）
	 * @return
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher(){
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
		hashedCredentialsMatcher.setHashIterations(2);//散列的次数，比如散列两次，相当于 md5(md5(""));
		return hashedCredentialsMatcher;
	}

	@Bean
	public MyShiroRealm myShiroRealm(){
		MyShiroRealm myShiroRealm = new MyShiroRealm(redisCacheManager(),hashedCredentialsMatcher());
		
		return myShiroRealm;
	}


   
   
   /**
    * 配置shiro redisManager
    * 使用的是shiro-redis开源插件
    * prefix = "spring.redis" 查看application文件
    * @return
    */
   @ConfigurationProperties(prefix = "spring.redis")
   private RedisManager redisManager() {
       RedisManager redisManager = new RedisManager();
       return redisManager;
   }
   
   /**
    * cacheManager 缓存 redis实现
    * 使用的是shiro-redis开源插件
    *
    * @return
    */
   private RedisCacheManager redisCacheManager() {
       RedisCacheManager redisCacheManager = new RedisCacheManager();
       redisCacheManager.setRedisManager(redisManager());
       
       return redisCacheManager;
   }
   
   /**
    * RedisSessionDAO shiro sessionDao层的实现 通过redis
    * 使用的是shiro-redis开源插件
    */
   //@Bean
   public RedisSessionDAO redisSessionDAO() {
       RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
       redisSessionDAO.setRedisManager(redisManager());
//     Custom your redis key prefix for session management, if you doesn't define this parameter,
//     shiro-redis will use 'shiro_redis_session:' as default prefix
//     redisSessionDAO.setKeyPrefix("");
       return redisSessionDAO;
   }
   

   
   /**
    * 安全管理器
    * 注：使用shiro-spring-boot-starter 1.4时，返回类型是SecurityManager会报错，直接引用shiro-spring则不报错
    *
    * @return
    */
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


   
   //自定义sessionManager
   @Bean
   public SessionManager sessionManager() {
       RedisSessionManager mySessionManager = new RedisSessionManager();
       mySessionManager.setSessionDAO(redisSessionDAO());
       return mySessionManager;
   }
	/**
	 *  开启shiro aop注解支持.
	 *  使用代理方式;所以需要开启代码支持;
	 * @param securityManager
	 * @return
	 */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
	


}
