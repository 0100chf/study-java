package cn.ks0100.common.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.ks0100.common.authorization.manager.TokenManager;
import cn.ks0100.common.config.Constants;
import cn.ks0100.common.exceptions.UnloginException;

/**
 * 如果controller 方法需要验证登录权限，使用注解cn.ks0100.common.aop.AuthorizationAnno
 * 监听该注解，如果没有登录权限抛出UnloginException异常
 * 如果用shiro一般不用，shiro会统一过滤管理controller的url.
 * 如果使用打开@Aspect和@Component注释
 * @author chen haifeng
 *
 */
//@Aspect
//@Component
public class AuthorizationAOP {

	//@Autowired
	private TokenManager manager;

	private static final Logger logger = LoggerFactory.getLogger(AuthorizationAOP.class);

	@Before("@annotation(cn.ks0100.common.aop.AuthorizationAnno)")
	public void doBefore(JoinPoint joinPoint) {
		
		logger.info("开始验证登录权限。。。。。。。");
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		String authorization = request.getHeader(Constants.AUTHORIZATION);
		// 验证token
		if (manager.checkToken(authorization)) {
			// 如果token验证成功，将token对应的用户id存在request中，便于之后注入
			String key=manager.getKeyBytokenStr(authorization);
			request.setAttribute(Constants.CURRENT_USER_ID, key);
		} else {
			throw new UnloginException();
		}

	}
}
