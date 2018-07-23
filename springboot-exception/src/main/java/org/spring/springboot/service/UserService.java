package org.spring.springboot.service;

import static cn.ks0100.common.utils.CheckUtil.check;
import static cn.ks0100.common.utils.CheckUtil.notEmpty;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.model.UserInfo;
import org.spring.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ks0100.common.authorization.manager.TokenManager;
import cn.ks0100.common.authorization.model.TokenModel;

@Service
public class UserService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
    private UserRepository userRepository;
	
    @Autowired
    private TokenManager tokenManager;
    
/*	public TokenModel loginUser2(String username,String password){
		 notEmpty(username, "user.username.input");
		 notEmpty(password, "user.password.input");
		 
		 UserInfo user=userRepository.findByUsername(username);
		 if (user == null || !user.getPassword().equals(password)) {  //用户未注册或密码错误
			 check(false,"user.login.error"); 
		 }
		 
		 TokenModel tm=new TokenModel();
		 tm.setAccount(username);
		 tm.setUserId(user.getUid());
		 return tokenManager.saveToken(tm);
		 
	}*/
	
	public TokenModel loginUser(String username, String password) {
		
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
		
		UserInfo user = userRepository.findByUsername(username);
		TokenModel tm = new TokenModel();
		tm.setAccount(username);
		tm.setUserId(user.getUid());
		return tokenManager.saveToken(tm);

	}
	
	public Boolean logout(){
		Subject subject = SecurityUtils.getSubject();
		if (subject.isAuthenticated()) {
			subject.logout();
		}
		return new Boolean(true);
	}
	
	public boolean deleteToken(String userId){
		
		 notEmpty(userId, "user.userid.input");
		 
		tokenManager.deleteToken(userId);
		return true;
	}
	
	public UserInfo findByUsername(String username) {
		notEmpty(username, "user.username.input");
        return userRepository.findByUsername(username);
    }
}
