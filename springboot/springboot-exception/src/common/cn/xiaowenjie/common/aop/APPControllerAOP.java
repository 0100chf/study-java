package cn.xiaowenjie.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.xiaowenjie.common.exceptions.CheckException;
import cn.xiaowenjie.common.exceptions.UnloginException;
import cn.xiaowenjie.common.result.ResultBean;

/**
 * 处理和包装异常
 * 
 * @author 肖文杰
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

		ResultBean<?> result;
		System.out.println("APPControllerAOP-------");
		try {
			result = (ResultBean<?>) pjp.proceed();
			logger.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
		} catch (Throwable e) {
			result = handlerAppException(pjp, e);
		}

		return result;
	}


	
	private ResultBean<?> handlerAppException(ProceedingJoinPoint pjp, Throwable e) {
		ResultBean<?> result = new ResultBean();

		// 已知异常
		if (e instanceof CheckException) {
			result.setMsg(e.getLocalizedMessage());
			result.setCode(ResultBean.FAIL);
		} else if (e instanceof UnloginException) {
			result.setMsg("Unlogin");
			result.setCode(ResultBean.NO_LOGIN);
		} else {
			logger.error(pjp.getSignature() + " error ", e);
			//TODO 发邮件
			result.setMsg(e.toString());
			result.setCode(ResultBean.FAIL);
		}

		return result;
	}
}
