package cn.xiaowenjie.common.authorization.manager.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import cn.xiaowenjie.common.authorization.manager.TokenManager;
import cn.xiaowenjie.common.authorization.model.TokenModel;
import cn.xiaowenjie.common.config.Constants;

/**
 * 通过Redis存储和验证token的实现类
 * @author chen haifeng
 *
 */
//@Primary
@Component
public class RedisTokenManager extends TokenManager {

	 @Autowired
   private StringRedisTemplate stringRedis;
	//private RedisTemplate redis;

/*    @Autowired
    public void setRedis(RedisTemplate redis) {
        this.redis = redis;
        //泛型设置成Long后必须更改对应的序列化方案
        redis.setKeySerializer(new JdkSerializationRedisSerializer());
    }*/

	 public  void saveTokenToCachce(TokenModel model){
		 
	        //存储到redis,userId作为Key，token作为Value，并设置过期时间
	        stringRedis.boundValueOps(model.getUserId()).set(model.getToken(), Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
	 }
	 

    
    public boolean checkToken(TokenModel model) {
        //通过userid 获取 token,验证传进来的的TokenModel
        String token = stringRedis.boundValueOps(model.getUserId()).get();
        if (model==null||token == null || !token.equals(model.getToken()) ) {
            return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        stringRedis.boundValueOps(model.getUserId()).expire(Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return true;
    }

	@Override
	public void deleteTokenByCache(String userId){
		stringRedis.delete(userId);
	}
	
}
