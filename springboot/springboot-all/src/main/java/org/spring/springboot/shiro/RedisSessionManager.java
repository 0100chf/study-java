package org.spring.springboot.shiro;

import java.io.Serializable;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionKey;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 自定义sessionId获取:
 *  传统结构项目中，shiro从cookie中读取sessionId以此来维持会话，在前后端分离的项目中（也可在移动APP项目使用），
 *  我们选择在ajax的请求头中传递sessionId，因此需要重写shiro获取sessionId的方式。
 *  自定义MySessionManager类继承DefaultWebSessionManager类，重写getSessionId方法，
 * @author chen haifeng
 *
 */
public class RedisSessionManager extends DefaultWebSessionManager {
	 
	private static final Logger logger = LoggerFactory.getLogger(RedisSessionManager.class);
	
    private static final String AUTHORIZATION = "Authorization";
 
    private static final String REFERENCED_SESSION_ID_SOURCE = "Stateless request";
 
    public RedisSessionManager() {
        super();
    }
 
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String id = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        //如果请求头中有 Authorization 则其值为sessionId
        if (!StringUtils.isEmpty(id)) {
        	logger.info("从移动端获取session id");
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, REFERENCED_SESSION_ID_SOURCE);
            //如果移动端登录成功，发放一串token字符串（也可以是shiro 生成的session id）给客户端，让其保存，每次登录拿着该token来请求
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, id);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return id;
        } else {
        	logger.info("从cookie获取session id");
            //否则按默认规则从cookie取sessionId
            return super.getSessionId(request, response);
        }
    }
    
    
    /**
     * 获取session
     * 优化shiro单次请求需要多次访问redis的问题
     * @param sessionKey
     * @return
     * @throws UnknownSessionException
     */
    @Override
    protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
    	logger.info("retrieveSession.............");
    	
    	Serializable sessionId = getSessionId(sessionKey);
 
        ServletRequest request = null;
        if (sessionKey instanceof WebSessionKey) {
            request = ((WebSessionKey) sessionKey).getServletRequest();
        }
        //从 request 中取 session 了，而且请求结束后 request 被销毁,这样减少一次request请求，多次访问redis的问题
        if (request != null && null != sessionId) {
            Object sessionObj = request.getAttribute(sessionId.toString());
            if (sessionObj != null) {
                return (Session) sessionObj;
            }
        }
 
        Session session = super.retrieveSession(sessionKey);
        if (request != null && null != sessionId) {
            request.setAttribute(sessionId.toString(), session);
        }
        return session;
    }
}
