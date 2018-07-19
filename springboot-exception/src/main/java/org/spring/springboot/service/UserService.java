package org.spring.springboot.service;

import static cn.xiaowenjie.common.utils.CheckUtil.check;
import static cn.xiaowenjie.common.utils.CheckUtil.notEmpty;

import org.spring.springboot.model.User;
import org.spring.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xiaowenjie.common.authorization.manager.TokenManager;
import cn.xiaowenjie.common.authorization.model.TokenModel;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;
	
    @Autowired
    private TokenManager tokenManager;
    
	public TokenModel loginUser(String username,String password){
		 notEmpty(username, "user.username.input");
		 notEmpty(password, "user.password.input");
		 
		 User user=userRepository.findByUsername(username);
		 if (user == null || !user.getPassword().equals(password)) {  //用户未注册或密码错误
			 check(false,"user.login.error"); 
		 }
		 
		 return tokenManager.createToken(user);
		 
	}
	
	public boolean deleteToken(String userId){
		
		 notEmpty(userId, "user.userid.input");
		 
		tokenManager.deleteToken(userId);
		return true;
	}
}
