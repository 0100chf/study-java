package cn.ks0100.common.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.ks0100.common.authorization.interceptor.CurrentUserMethodArgumentResolver;

/**
 * 配置类，增加自定义拦截器和解析器
 * @see cn.ks0100.common.authorization.interceptor.scienjus.authorization.resolvers.CurrentUserMethodArgumentResolver
 * @see com.scienjus.authorization.interceptor.AuthorizationInterceptor
 * @author ScienJus
 * @date 2015/7/30.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {


    @Autowired
    private CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver;

    
   // @Override
 /*   public void addInterceptors(InterceptorRegistry registry) {
       // registry.addInterceptor(authorizationInterceptor);
    }*/

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserMethodArgumentResolver);
    }
    
    
/*    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
        		.addResourceLocations("classpath:/META-INF/resources/")
        		.addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }*/
    
    //@Override
/*    public void configureHandlerExceptionResolvers1(List<HandlerExceptionResolver> exceptionResolvers) {
    	 exceptionResolvers.add(new HandlerExceptionResolver() {
             @Override
             public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
            	 ResultBean result=new ResultBean() ;
                 if (handler instanceof HandlerMethod) {
                     HandlerMethod handlerMethod = (HandlerMethod) handler;

                 } else {
                	 System.out.println("configureHandlerExceptionResolvers---------------");
                     if (e instanceof NoHandlerFoundException) {
                         result=new ResultBean(CheckUtil.getResources().getMessage("interface.no.found",null, UserUtil.getLocale()),ResultBean.NO_FOUND);
                     } else {
                         result= new ResultBean(e.fillInStackTrace());

                     }
                 }
                 responseResult(response, result);
                 return new ModelAndView();
             }

         });
    	 
    }*/
/*	    private void responseResult(HttpServletResponse response, ResultBean result) {
	        response.setCharacterEncoding("UTF-8");
	        response.setHeader("Content-type", "application/json;charset=UTF-8");
	        response.setStatus(200);
	        try {
	        	//JSONObject jsresult = new JSONObject();
	            response.getWriter().write(JSON.toJSONString(result));
	        } catch (IOException ex) {
	        }
	    } */ 

}
