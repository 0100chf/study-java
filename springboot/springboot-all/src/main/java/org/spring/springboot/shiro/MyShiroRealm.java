package org.spring.springboot.shiro;

import static org.spring.springboot.common.utils.CheckUtil.notEmpty;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.model.SysPermission;
import org.spring.springboot.model.SysRole;
import org.spring.springboot.model.UserInfo;
import org.spring.springboot.service.UserService;
import org.springframework.context.annotation.Lazy;

public class MyShiroRealm extends AuthorizingRealm {
	
	private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);
	
    public MyShiroRealm(CacheManager cacheManager, CredentialsMatcher matcher) {
        super(cacheManager, matcher);
    }
    
    @Resource
    @Lazy
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    	try{
    	   	logger.info("MyShiroRealm.doGetAuthorizationInfo() 开始验证权限。。。。。。。。。。。。。");
           
            UserInfo userInfo  = (UserInfo)principals.getPrimaryPrincipal();
            for(SysRole role:userInfo.getRoleList()){
                authorizationInfo.addRole(role.getRole());
                for(SysPermission p:role.getPermissions()){
                    authorizationInfo.addStringPermission(p.getPermission());
                }
            }
    	}catch(UnauthorizedException e){
    		throw e;
    	}catch(Exception e){
    		throw e;
    	}
 
        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        logger.info("MyShiroRealm.doGetAuthenticationInfo() 开始校验帐号密码。。。。。。。。。。。。。");
        
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        notEmpty(token.getUsername(), "user.username.input");
	    notEmpty(token.getPassword().toString(), "user.password.input");
		 
	    UserInfo user=userService.findByUsername(token.getUsername());
	    if(user!=null){
	    	 /**
	    	  * user对象是从数据库里取出的，shiro会把user.getName()和user.getPassword()比对token中的
	    	  * token.getUsername()和token.getPassword()，密码salt会自动加上算法生成并比对
	    	  */
	    	  //
	    	 SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
	    			 //user.getUsername(), //帐号
	    			 user, //放入user，就当作shiro的session value用，这里最好把user类导入到另外一个shirouser类，作为session使用。
	    			 user.getPassword(), //密码
	                 ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
	                 getName()  //realm name
	         );
	         return authenticationInfo;
	    }else{
	    	return null;
	    }

    }

}