package cn.ks0100.common.authorization.manager.impl;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import cn.ks0100.common.authorization.manager.TokenManager;
import cn.ks0100.common.authorization.model.TokenModel;
import cn.ks0100.common.config.Constants;

/**
 * 通过Redis存储和验证token的实现类
 * 
 * @author chen haifeng
 *
 */
// @Primary
@Component
public class RedisTokenManager extends TokenManager {

	@Resource
	private RedisTemplate<Serializable, Serializable> redisTemplate;

	@Override
	public void saveTokenToCachce(String key, TokenModel model) {
		// 存储到redis,userId作为Key，token作为Value，并设置过期时间
		redisTemplate.boundValueOps(key).set(model, Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);

	}

	/*
	 * public boolean checkToken(TokenModel model) { //通过userid 获取
	 * token,验证传进来的的TokenModel String token =
	 * stringRedis.boundValueOps(model.getUserId()).get(); if
	 * (model==null||token == null || !token.equals(model.getToken()) ) { return
	 * false; } //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
	 * stringRedis.boundValueOps(model.getUserId()).expire(Constants.
	 * TOKEN_EXPIRES_HOUR, TimeUnit.HOURS); return true; }
	 */

	@Override
	public void deleteTokenByCache(String key) {
		redisTemplate.delete(key);
	}

	@Override
	public TokenModel getTokenModelByCachce(String key) {

		TokenModel tm = (TokenModel) redisTemplate.boundValueOps(key).get();

		if (tm != null) {
			// 如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
			redisTemplate.boundValueOps(key).expire(Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
		}
		return tm;
	}

}
