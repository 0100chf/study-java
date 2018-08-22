package org.spring.springboot.controllers;

import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.spring.springboot.common.result.ResultBean;
import org.spring.springboot.common.result.ResultStatus;
import org.spring.springboot.common.utils.CheckUtil;
import org.spring.springboot.common.utils.LocalUtil;
import io.swagger.annotations.ApiOperation;

/**
 * 获取和删除token的请求地址，在Restful设计中其实就对应着登录和退出登录的资源映射
 * @author ScienJus
 * @date 2015/7/30.
 */
@Controller
//@RequestMapping("/tokens")
public class HomeController {

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

    /**
     * web请求后进入的主页
     * @return
     */
    @RequestMapping(value={"/","/index"},method = RequestMethod.GET)
    public String index(){
        return"index";
    }
	
    /**
     * web请求后进入的登录页
     * @return
     */
    @RequestMapping(value = "/web/to-login",method = RequestMethod.GET)
    public String webToLogin(){
        return"to-login";
    }
    
	/**
	 * web登录请求
	 * @param username
	 * @param password
	 * @return
	 */
	 @RequestMapping(value = "/web/login", method = RequestMethod.POST)
	 public String webLogin(@RequestParam String username, @RequestParam String password){
		 userService.loginUser(username,password);
		 return "index";
	}
	 
	
	/**
	 * web请求登出
	 * @return
	 */
	@RequestMapping(value="/web/loginout", method = RequestMethod.GET)
	public String webLoginOut() {
		userService.logout();
		return "to-login";
	}
	
	
	/**
	 * app接口，登录请求
	 * @param username
	 * @param password
	 * @return
	 */
	 @RequestMapping(value = "/app/login", method = RequestMethod.POST)
	 @ResponseBody
	 @ApiOperation(value = "登录")
	 public ResultBean<String> appLogin(@RequestParam String username, @RequestParam String password){
	    	return new ResultBean<String>(userService.loginUser(username,password));
	}
	 
	/**
	 * app接口，未登录返回的json信息
	 * @return
	 */
	@RequestMapping(value = "/app/unlogin", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResultStatus> unlogin() {
		ResultStatus s = new ResultStatus();
		String errorMessage = CheckUtil.getResources().getMessage("user.app.not.login", null, LocalUtil.getLocale());
		s.setMsg(errorMessage);
		s.setMsgCode(ResultStatus.NO_LOGIN);

		return new ResponseEntity<ResultStatus>(s, HttpStatus.UNAUTHORIZED);
	}

	/**
	 * app请求登出
	 * @return
	 */
	@RequestMapping(value="/app/loginout", method = RequestMethod.GET)
	public ResultBean<Boolean> appLoginOut() {
		return new ResultBean<Boolean>(userService.logout());
		
	}
	
/*    @RequestMapping(value = "/app/login2", method = RequestMethod.POST)
    @ResponseBody
	 @ApiOperation(value = "登录")
	 public ResponseEntity<?> login(HttpServletRequest request){
    	 System.out.println("HomeController.login()");
         // 登录失败从request中获取shiro处理的异常信息。
         // shiroLoginFailure:就是shiro异常类的全类名.
         String exception = (String) request.getAttribute("shiroLoginFailure");
         System.out.println("exception=" + exception);
         String msg = "";
         if (exception != null) {
             if (UnknownAccountException.class.getName().equals(exception)) {
                 System.out.println("UnknownAccountException -- > 账号不存在：");
                 msg = "UnknownAccountException -- > 账号不存在：";
             } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                 System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                 msg = "IncorrectCredentialsException -- > 密码不正确：";
             } else if ("kaptchaValidateFailed".equals(exception)) {
                 System.out.println("kaptchaValidateFailed -- > 验证码错误");
                 msg = "kaptchaValidateFailed -- > 验证码错误";
             } else {
                 msg = "else >> "+exception;
                 System.out.println("else -- >" + exception);
             }
         }
       //  map.put("msg", msg);
         System.out.println("登录成功。。。" );
         // 此方法不处理登录成功,由shiro进行处理
         return new ResponseEntity<>("登录成功", HttpStatus.OK);
	}*/
    

	 
	//TODO @CurrentUser 不能指向实体类，指向VO
	//该方法不能用，出现java.lang.StackOverflowError
	 //UserInfo user做参数会把UserInfo关联的表查询出来，里面有 
  // @RequestMapping(value = "/logout",method = RequestMethod.DELETE)
   /*   @ApiOperation(value = "退出登录")
      @ApiImplicitParams({
              @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
      })*/
/*    @AuthorizationAnno
    public ResultBean<Boolean> logout(@CurrentUser UserInfo user) {
    	 return new ResultBean<Boolean>(userService.deleteToken(user.getUid()));
    }*/
    
    


}
