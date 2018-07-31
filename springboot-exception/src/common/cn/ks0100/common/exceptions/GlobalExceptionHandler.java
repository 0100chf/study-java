package cn.ks0100.common.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import cn.ks0100.common.result.ResultStatus;

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
    		//String errorMessage=CheckUtil.getResources().getMessage("interface.no.found",null, UserUtil.getLocale());
    		
    		//return new ResultBean(new ResultStatus(errorMessage,ResultStatus.NO_FOUND),HttpStatus.NOT_FOUND);
    		return ResultStatus.exceptionResult(ResultStatus.NO_FOUND);
    	}else if(exception instanceof UnloginException){
    		//String errorMessage=CheckUtil.getResources().getMessage("user.not.login",null, UserUtil.getLocale());
    		//return new ResultBean(new ResultStatus(errorMessage,ResultStatus.NO_LOGIN),HttpStatus.UNAUTHORIZED);
    		
    		return ResultStatus.exceptionResult(ResultStatus.NO_LOGIN);
    	}else if(exception instanceof UnauthorizedException){
    		//String errorMessage=CheckUtil.getResources().getMessage("user.not.permission",null, UserUtil.getLocale());
    		//return new ResultBean(new ResultStatus(errorMessage,ResultStatus.NO_PERMISSION),HttpStatus.UNAUTHORIZED);
    		return ResultStatus.exceptionResult(ResultStatus.NO_PERMISSION);
    	}
    	else{
    		//return new ResultBean(new ResultStatus(exception.fillInStackTrace().toString(),ResultStatus.FAIL),HttpStatus.INTERNAL_SERVER_ERROR);
    		return ResultStatus.exceptionResult(exception.fillInStackTrace().toString());
    	}
    }
    
}
