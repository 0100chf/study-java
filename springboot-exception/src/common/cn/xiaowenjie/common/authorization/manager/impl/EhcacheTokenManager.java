package cn.xiaowenjie.common.authorization.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import cn.xiaowenjie.common.authorization.manager.TokenManager;
import cn.xiaowenjie.common.authorization.model.TokenModel;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * 通过Ehcache存储和验证token的实现类
 * @author chen haifeng
 *
 */
@Primary
@Component
public class EhcacheTokenManager extends TokenManager {

	@Autowired
	private CacheManager cacheManager;
	
	
	 public  void saveTokenToCachce(TokenModel model){
		 Element element = new Element(model.getUserId(), model.getToken());
	      getCache().put(element);
	 }
	 

	private Cache getCache(){
		return cacheManager.getCache("tokenCache");
	}
	@Override
	public boolean checkToken(TokenModel model) {
		 if (model == null) {
	            return false;
	        }
	        //通过userid 获取 token,验证传进来的的TokenModel
			Element element=getCache().get(model.getUserId());
			if(element!=null){
				String token=(String)element.getObjectValue();
				 if (token == null || !token.equals(model.getToken()) ) {
			            return false;
			        }
			}else{
				 return false;
			}
			 //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
			getCache().replace(element);
	        
	        return true;
	}

	@Override
	public void deleteTokenByCache(String userId){
		 getCache().remove(userId);
	}

}
