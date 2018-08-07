package cn.xiaowenjie.common.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class WebControllerAOP {
	private static final Logger logger = LoggerFactory.getLogger(WebControllerAOP.class);
	
	//统一输出的error页面
	public static final String DEFAULT_ERROR_VIEW = "error";
	
	 @Around("@annotation(cn.xiaowenjie.common.aop.WebControllerAnno)")
	public String handlerControllerMethod(ProceedingJoinPoint pjp){
		long startTime = System.currentTimeMillis();

		String result ;
		//System.out.println("WebControllerAOP-------");
		try {
			result =  (String)pjp.proceed();
			logger.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
			return result;
		} catch (Throwable t) {
			handlerWebException(t);
			return DEFAULT_ERROR_VIEW;
		}

	}
	
	 private void handlerWebException(Throwable t){
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			request.setAttribute("exception",errorTrackSpace1(t));
			request.setAttribute("url", request.getRequestURL());
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
    

}
