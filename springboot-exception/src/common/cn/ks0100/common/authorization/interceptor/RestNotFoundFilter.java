package cn.ks0100.common.authorization.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

import cn.ks0100.common.exceptions.UnloginException;
import cn.ks0100.common.result.ResultBean;
import cn.ks0100.common.result.ResultStatus;
import cn.ks0100.common.utils.CheckUtil;
import cn.ks0100.common.utils.UserUtil;

/**
 * spring boot 遇到错误，会跳到error页面，这里使用请求转发，拦截到/error请求和404错误，返回404错误接口
 * @author chen haifeng
 *
 */
//@RestController
public class RestNotFoundFilter implements ErrorController{
	
    private static final String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH)
    public ResponseEntity<ResultStatus> handleError(HttpServletRequest request,Exception exception) {
    	
    	ResultStatus s=new ResultStatus();
    	
    	if(exception instanceof NoHandlerFoundException){
        	
        	String errorMessage=CheckUtil.getResources().getMessage("interface.no.found",null, UserUtil.getLocale());
        	s.setMsg(errorMessage);
        	s.setErrorCode(ResultStatus.NO_FOUND);
    		
        	return new ResponseEntity<ResultStatus>(s,HttpStatus.NOT_FOUND);
    	}else if(exception instanceof UnloginException){
    		String errorMessage=CheckUtil.getResources().getMessage("user.not.login",null, UserUtil.getLocale());
    		s.setMsg(errorMessage);
    		s.setErrorCode(ResultStatus.NO_LOGIN);
    		
    		return new ResponseEntity<ResultStatus>(s,HttpStatus.UNAUTHORIZED);
    		
    	}else{
    		s.setMsg(exception.fillInStackTrace().toString());
    		s.setErrorCode(ResultStatus.FAIL);
    		return new ResponseEntity<ResultStatus>(s,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
    }

	//把Exception错误轨迹转成字符串,用\r\n\t分隔
    private static String errorTrackSpace1(Throwable t) {
    	//e.printStackTrace();
    	
        StringBuffer sb = new StringBuffer();
        if (t != null) {
        	sb.append(t.getMessage()).append("\r\n\t");
            for (StackTraceElement element :  t.getStackTrace()) {
                sb.append("\r\n\t").append(element);
            }
        }
        return sb.length() == 0 ? null : sb.toString();
    }
    
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

}
