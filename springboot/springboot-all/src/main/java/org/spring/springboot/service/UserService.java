package org.spring.springboot.service;

import static org.spring.springboot.common.utils.CheckUtil.notEmpty;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.spring.springboot.model.UserInfo;
import org.spring.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	public static final String KEY_USER = "user";
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
    private UserRepository userRepository;
	
	
	public String loginUser(String username, String password) {
		
		logger.info("进入UserService.loginUser()。。。。。。。。。。。。");
		notEmpty(username, "user.username.input");
		notEmpty(password, "user.password.input");

		// 把用户名密码，放到shiro的UsernamePasswordToken对象，便于shiro校验
		AuthenticationToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			logger.info("换帐号先登出，。。。。。。。。。。。。");
			subject.logout();
		} 
		
		subject.login(token);
		//下一步转到MyShiroRealm.doGetAuthenticationInfo()
		
		subject.hasRole("system");
		
		// 把用户帐号放到logback，便于日志追踪
	    MDC.put(KEY_USER, username);
		//成功返回sessionid给移动端
		return subject.getSession().getId().toString();

	}
	
	public Boolean logout(){
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			subject.logout();
			MDC.remove(KEY_USER);
		}
		return new Boolean(true);
	}
	
/*	public boolean deleteToken(String userId){
		
		notEmpty(userId, "user.userid.input");
		MDC.remove(KEY_USER);
		return true;
	}*/
	
	public UserInfo findByUsername(String username) {
		notEmpty(username, "user.username.input");
        return userRepository.findByUsername(username);
    }
}
