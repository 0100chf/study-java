package cn.xiaowenjie.common.authorization.manager;

import java.util.UUID;

import org.slf4j.MDC;

import cn.xiaowenjie.common.authorization.model.BaseUser;
import cn.xiaowenjie.common.authorization.model.TokenModel;

/**
 * 对Token进行操作的接口
 * @author ScienJus
 * @date 2015/7/31.
 */
public abstract class TokenManager {

	public static final String KEY_USER = "user";
	  

    
    /**
     * 创建一个token关联上指定用户
     * @param userId 指定用户的id
     * @return 生成的token
     */
    public TokenModel initToken(BaseUser user){
    	 //使用uuid作为源token，和userId 组成TokenModel
        String token = UUID.randomUUID().toString().replace("-", "");
        String userId=String.valueOf(user.getId());
        
        TokenModel model = new TokenModel(userId, token,user.getUsername());
        // 把用户信息放到log4j
        MDC.put(KEY_USER, user.getUsername());
        return model;
    }
    
    public abstract void saveTokenToCachce(TokenModel model);
    
    /**
     * 创建一个token关联上指定用户
     * @param userId 指定用户的id
     * @return 生成的token
     */
    public TokenModel createToken(BaseUser user){
    	TokenModel model =initToken(user);
    	saveTokenToCachce(model);
    	
    	return model;
    }
    /**
     * 检查token是否有效
     * @param model token
     * @return 是否有效
     */
    public abstract boolean checkToken(TokenModel model);

    /**
     * 从字符串中解析token
     * @param authentication 加密后的字符串
     * @return
     */
	public TokenModel getToken(String authentication) {
		if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施
        String userId = param[0];
        String token = param[1];
       // String username = param[2];
        return new TokenModel(userId, token,null);
	}


    /**
     * 清除token
     * @param userId 登录用户的id
     */
    public  void deleteToken(String userId){
    	deleteTokenByCache(userId);
    	MDC.remove(KEY_USER);
    }
    
    public abstract void deleteTokenByCache(String userId);

}
