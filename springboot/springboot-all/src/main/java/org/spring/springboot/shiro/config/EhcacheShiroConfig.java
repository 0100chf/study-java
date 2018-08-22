package org.spring.springboot.shiro.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;



//@Configuration
public class EhcacheShiroConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(EhcacheShiroConfig.class);
	
	// @Value("${my.ehcache..config}")
	// private String ehcacheXml;
	 
	@Bean
	public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
		
		logger.info("ShiroConfig_ehcache ShiroConfiguration.shirFilter().....................");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//拦截器.
		Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
		// 配置不会被拦截的链接 顺序判断
		filterChainDefinitionMap.put("/static/**", "anon");
		
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
	public MyShiroRealm myShiroRealm(CacheManager cacheManager){
		MyShiroRealm myShiroRealm = new MyShiroRealm(cacheManager,hashedCredentialsMatcher());
		myShiroRealm.setAuthenticationCacheName("authenticationCache");
		myShiroRealm.setAuthorizationCacheName("authorizationCache");
	        
		return myShiroRealm;
	}

    
    /**
     * 缓存管理器
     * 把user对象 序列化作为key
     * @param cacheManager
     * @return
     */
    @Bean
    public EhcacheShiroManager shiroSpringCacheManager(org.springframework.cache.CacheManager cacheManager) {
        return new EhcacheShiroManager(cacheManager);
    }
    
    /**
     * 安全管理器
     * 注：使用shiro-spring-boot-starter 1.4时，返回类型是SecurityManager会报错，直接引用shiro-spring则不报错
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(CacheManager cacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm(cacheManager));
        securityManager.setCacheManager(cacheManager);
        return securityManager;
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
	
	/**
	 * aop代理,使用shiro-Ehcache 一定要加
	 * @return
	 */
	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
	    DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
	    defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
	    return defaultAdvisorAutoProxyCreator;
	}
	
    /**
     * 设置为共享模式,使用shiro-Ehcache 一定要加
     * @return
     */
    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        cacheManagerFactoryBean.setShared(true);
        return cacheManagerFactoryBean;
    }
    
/*	@Bean(name="simpleMappingExceptionResolver")
	public SimpleMappingExceptionResolver createSimpleMappingExceptionResolver() {
		
		logger.info("SimpleMappingExceptionResolver.createSimpleMappingExceptionResolver().....................");
		SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		mappings.setProperty("DatabaseException", "databaseError");//数据库异常处理
		mappings.setProperty("UnauthorizedException","403");
		r.setExceptionMappings(mappings);  // None by default
		r.setDefaultErrorView("error");    // No default
		r.setExceptionAttribute("ex");     // Default is "exception"
		//r.setWarnLogCategory("example.MvcLogger");     // No default
		return r;
	}*/
}