package org.spring.springboot.common.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import org.spring.springboot.common.result.ResultStatus;

/**
 * 捕捉自定义异常后统一处理
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	/**
	 * 处理404接口找不到等全局异常
	 * 已知的接口异常在APPControllerAOP处理
	 * 已知和未知的页面异常在WebControllerAOP处理
	 */
    @ExceptionHandler(value =Exception.class )
    public Object handlerException(HttpServletRequest request,Exception exception) {
        
    	logger.info("GlobalExceptionHandler.handlerException().............");
    	if(exception instanceof NoHandlerFoundException){
    		
    		return ResultStatus.exceptionResult(ResultStatus.NO_FOUND);
    	}
    	//else if(exception instanceof UnloginException){
    		
    		//return ResultStatus.exceptionResult(ResultStatus.NO_LOGIN);
    	//}
    	else if(exception instanceof UnauthorizedException){
    		return ResultStatus.exceptionResult(ResultStatus.NO_PERMISSION);
    	}
    	else{
    		return ResultStatus.exceptionResult(exception.fillInStackTrace().toString());
    	}
    }
    
}
