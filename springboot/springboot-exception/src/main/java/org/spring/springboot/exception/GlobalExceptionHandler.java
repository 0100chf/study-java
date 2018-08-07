package org.spring.springboot.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import cn.xiaowenjie.common.result.ResultBean;
import cn.xiaowenjie.common.utils.CheckUtil;
import cn.xiaowenjie.common.utils.UserUtil;

/**
 * 捕捉自定义异常后统一处理
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    
	/**
	 * 处理404接口找不到等全局异常
	 * 已知的接口异常在APPControllerAOP处理
	 * 已知和未知的页面异常在WebControllerAOP处理
	 */
    @ExceptionHandler(value =Exception.class )
    public Object handlerException(HttpServletRequest request,Exception exception) {
        
    	if(exception instanceof NoHandlerFoundException){
    		
    		return new ResultBean(CheckUtil.getResources().getMessage("interface.no.found",null, UserUtil.getLocale()),ResultBean.NO_FOUND);
    	}else{
    		return new ResultBean(exception.fillInStackTrace());
    	}
    }
    
}
