package org.spring.springboot.controllers;

import org.spring.springboot.model.User;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.xiaowenjie.common.aop.AuthorizationAnno;
import cn.xiaowenjie.common.authorization.annotation.CurrentUser;
import cn.xiaowenjie.common.authorization.model.TokenModel;
import cn.xiaowenjie.common.result.ResultBean;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 获取和删除token的请求地址，在Restful设计中其实就对应着登录和退出登录的资源映射
 * @author ScienJus
 * @date 2015/7/30.
 */
@RestController
@RequestMapping("/tokens")
public class TokenController {

	@Autowired
	private UserService userService;

    
 //   @RequestMapping(method = RequestMethod.POST)
   // @ApiOperation(value = "登录")
/*    public ResponseEntity<ResultModel> login(@RequestParam String username, @RequestParam String password) {
        Assert.notNull(username, "username can not be empty");
        Assert.notNull(password, "password can not be empty");

        User user = userRepository.findByUsername(username);
        if (user == null ||  //未注册
                !user.getPassword().equals(password)) {  //密码错误
            //提示用户名或密码错误
            return new ResponseEntity<>(ResultModel.error(ResultStatus.USERNAME_OR_PASSWORD_ERROR), HttpStatus.NOT_FOUND);
        }
        
        //生成一个token，保存用户登录状态
        TokenModel model = tokenManager.createToken(user.getId());
        return new ResponseEntity<>(ResultModel.ok(model), HttpStatus.OK);
    }*/

	
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	 @ApiOperation(value = "登录")
	 public ResultBean<TokenModel> login(@RequestParam String username, @RequestParam String password){
	    	return new ResultBean<TokenModel>(userService.loginUser(username,password));
	}
	 
    @RequestMapping(value = "/logout",method = RequestMethod.DELETE)
     @ApiOperation(value = "退出登录")
      @ApiImplicitParams({
              @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
      })
    @AuthorizationAnno
    public ResultBean<Boolean> logout(@CurrentUser User user) {
    	 return new ResultBean<Boolean>(userService.deleteToken(user.getId()));
    }
    
    


}
