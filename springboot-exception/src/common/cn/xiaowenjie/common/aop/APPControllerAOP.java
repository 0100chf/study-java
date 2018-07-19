package cn.xiaowenjie.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import cn.xiaowenjie.common.exceptions.CheckException;
import cn.xiaowenjie.common.exceptions.UnloginException;
import cn.xiaowenjie.common.result.ResultBean;
import cn.xiaowenjie.common.result.ResultStatus;
import cn.xiaowenjie.common.utils.CheckUtil;
import cn.xiaowenjie.common.utils.UserUtil;

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

	@Pointcut("execution(public cn.xiaowenjie.common.result.ResultBean *(..))")
    public void controllerMethod(){}
	
	@Around("controllerMethod()")
	public Object handlerControllerMethod(ProceedingJoinPoint pjp) {
		long startTime = System.currentTimeMillis();

		ResultBean<?>  result=null;
		//System.out.println("APPControllerAOP-------");
		try {
			result =  (ResultBean<?>)pjp.proceed();
			logger.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
			ResultStatus status=new ResultStatus(result.getData());
			return  new ResultBean(status);
		} catch (Throwable e) {
			//ResultStatus status=handlerAppException2(pjp, e);
			//return new ResultBean(status,HttpStatus.INTERNAL_SERVER_ERROR);
			return handlerAppException(pjp, e);
		}
	}

	
	private ResultBean<ResultStatus> handlerAppException(ProceedingJoinPoint pjp, Throwable e) {
		//ResultBean r=new ResultBean(new ResultStatus(errorMessage,ResultStatus.NO_FOUND));
		ResultStatus status=new ResultStatus();
		
		
		// 已知异常,可以登录
		if (e instanceof CheckException) {
			
			status.setMsg(e.getLocalizedMessage());
			status.setErrorCode(ResultStatus.FAIL);
			return new ResultBean<>(status,HttpStatus.INTERNAL_SERVER_ERROR);//500
		} else if (e instanceof UnloginException) {
			String errorMessage=CheckUtil.getResources().getMessage("user.not.login",null, UserUtil.getLocale());
			
			status.setMsg(errorMessage);
			status.setErrorCode(ResultStatus.NO_LOGIN);
			return new ResultBean<>(status,HttpStatus.UNAUTHORIZED);//401，未登录
		} else {
			logger.error(pjp.getSignature() + " error ", e);
			//TODO 发邮件
			status.setMsg(e.toString());
			status.setErrorCode(ResultStatus.FAIL);
			return new ResultBean<>(status,HttpStatus.INTERNAL_SERVER_ERROR);//500
		}

		
		
	}
}
