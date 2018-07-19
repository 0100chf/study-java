package cn.xiaowenjie.common.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import cn.xiaowenjie.common.result.ResultBean;
import cn.xiaowenjie.common.result.ResultStatus;
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
    		String errorMessage=CheckUtil.getResources().getMessage("interface.no.found",null, UserUtil.getLocale());
    		
    		//ResultBean r=new ResultBean(errorMessage,ResultBean.NO_FOUND);
    		return new ResultBean(new ResultStatus(errorMessage,ResultStatus.NO_FOUND),HttpStatus.NOT_FOUND);
    		//return new ResultBean(errorMessage,ResultBean.NO_FOUND,HttpStatus.NOT_FOUND);
    		//return new ResponseEntity<>(r,HttpStatus.NOT_FOUND);
    	}else if(exception instanceof UnloginException){
    		String errorMessage=CheckUtil.getResources().getMessage("user.not.login",null, UserUtil.getLocale());
    		return new ResultBean(new ResultStatus(errorMessage,ResultStatus.NO_LOGIN),HttpStatus.UNAUTHORIZED);
    	}else{
    		//ResultBean r= new ResultBean(exception.fillInStackTrace());
    		
    	//	ResultBean r=new ResultBean(new ResultStatus(exception.fillInStackTrace().toString(),ResultStatus.FAIL));
    		return new ResultBean(new ResultStatus(exception.fillInStackTrace().toString(),ResultStatus.FAIL),HttpStatus.INTERNAL_SERVER_ERROR);
    		//return new ResultBean(exception.fillInStackTrace().toString(),ResultBean.FAIL);
    	//	return new ResponseEntity<>(r,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
}
