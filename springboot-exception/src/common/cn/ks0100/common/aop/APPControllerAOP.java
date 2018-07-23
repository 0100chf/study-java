package cn.ks0100.common.aop;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import cn.ks0100.common.exceptions.CheckException;
import cn.ks0100.common.exceptions.UnloginException;
import cn.ks0100.common.result.ResultBean;
import cn.ks0100.common.result.ResultStatus;

/**
 * 接口开发一般在controller返回ResultBean
 * 对此拦截，计算运行时间和统一处理异常，如果有异常返回异常json
 * @author chen haifeng
 *
 */
@Aspect
@Component
public class APPControllerAOP {
	private static final Logger logger = LoggerFactory.getLogger(APPControllerAOP.class);

	@Pointcut("execution(public cn.ks0100.common.result.ResultBean *(..))")
    public void controllerMethod(){}
	
	@Around("controllerMethod()")
	public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
		long startTime = System.currentTimeMillis();

		ResultBean<?>  result=null;
		logger.info("APPControllerAOP-------");
		try {
			result =  (ResultBean<?>)pjp.proceed();
			logger.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
			return  new ResultBean(new ResultStatus(result.getData()));
		} catch (Throwable e) {
			return handlerAppException(pjp, e);
		}
	}

	
	private ResultBean<ResultStatus> handlerAppException(ProceedingJoinPoint pjp, Throwable e) {
		ResultStatus status=new ResultStatus();
		
		
		// 已知异常,可以登录
		if (e instanceof CheckException) {
			
			//status.setMsg(e.getLocalizedMessage());
			//status.setErrorCode(ResultStatus.FAIL);
			//return new ResultBean<>(status,HttpStatus.INTERNAL_SERVER_ERROR);//500
			return ResultStatus.exceptionResult(e.getLocalizedMessage());
		} else if (e instanceof UnloginException) {
			//String errorMessage=CheckUtil.getResources().getMessage("user.not.login",null, UserUtil.getLocale());
			
			//status.setMsg(errorMessage);
			//status.setErrorCode(ResultStatus.NO_LOGIN);
			//return new ResultBean<>(status,HttpStatus.UNAUTHORIZED);//401，未登录
			
			return ResultStatus.exceptionResult(ResultStatus.NO_LOGIN);
			
		} else if (e instanceof UnknownAccountException) {  //shiro 异常
			//String errorMessage=CheckUtil.getResources().getMessage("user.login.error",null, UserUtil.getLocale());
			
			//status.setMsg(errorMessage);
			//status.setErrorCode(ResultStatus.NO_LOGIN);
			//return new ResultBean<>(status,HttpStatus.NOT_ACCEPTABLE);//406，帐号不存在，不允许进入
			
			return ResultStatus.exceptionResult(ResultStatus.INCORRECT_LOGIN);
			
		}
		else if (e instanceof IncorrectCredentialsException) { //shiro 异常
			//String errorMessage=CheckUtil.getResources().getMessage("user.login.error",null, UserUtil.getLocale());
			
			//status.setMsg(errorMessage);
			//status.setErrorCode(ResultStatus.NO_LOGIN);
			//return new ResultBean<>(status,HttpStatus.NOT_ACCEPTABLE);//406，密码不正确，不允许进入
			return ResultStatus.exceptionResult(ResultStatus.INCORRECT_LOGIN);
			
		} else if ("kaptchaValidateFailed".equals(e)) { //406，验证码错误，不允许进
			//String errorMessage=CheckUtil.getResources().getMessage("user.login.vericode.error",null, UserUtil.getLocale());
			
			//status.setMsg(errorMessage);
			//status.setErrorCode(ResultStatus.NO_LOGIN);
			//return new ResultBean<>(status,HttpStatus.NOT_ACCEPTABLE);//406，验证码错误，不允许进入
			return ResultStatus.exceptionResult(ResultStatus.VERICODE_ERROR);
		} 
/*		else if (User.STATUS_LOCK.equals(user.getStatus())) {
			throw new LockedAccountException("账号已被锁定,请联系管理员！");
		}*/
		else {
			logger.error(pjp.getSignature() + " error ", e);
			//TODO 发邮件
			status.setMsg(e.toString());
			status.setErrorCode(ResultStatus.FAIL);
			return new ResultBean<>(status,HttpStatus.INTERNAL_SERVER_ERROR);//500
		}

		
		
	}
}
