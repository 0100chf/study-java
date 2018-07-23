package cn.xiaowenjie.common.authorization.manager;

import org.slf4j.MDC;

import cn.xiaowenjie.common.authorization.model.TokenModel;

/**
 * 对Token进行操作的接口
 * @author ScienJus
 * @date 2015/7/31.
 */
public abstract class TokenManager {

	public static final String KEY_USER = "user";
	  

    //已经通过用户名密码，产生Token对象，一般是用户信息
 /*   public TokenModel initToken(UserInfo user){
    	 //使用uuid作为源token，和userId 组成TokenModel
        String token = UUID.randomUUID().toString().replace("-", "");
        String userId=String.valueOf(user.getUid());
        
        TokenModel model = new TokenModel(userId, token,user.getUsername());
        // 把用户信息放到log4j
        MDC.put(KEY_USER, user.getUsername());
        return model;
    }*/
   
   /**
    * 把Token对象保存在缓存中
    * @param model
    * @return
    */
    public TokenModel saveToken(TokenModel model){
    	
    	// 把用户帐号放到log4j，便于日志追踪
        MDC.put(KEY_USER, model.getAccount());
    	saveTokenToCachce(model.getKey(),model);
    	
    	return model;
    }
    
    public abstract void saveTokenToCachce(String key,TokenModel model);
    
    /**
     * 检查token是否有效
     * @param model token
     * @return 是否有效
     */
    public boolean checkToken(String tokenStr){
    	//1.解析tokenStr 生成数据如userid。
    	String key=getKeyBytokenStr(tokenStr);
    	if(key==null){
    		return false;
    	}
    	//2.从缓存中取得TokenModel对象
    	TokenModel tm=getTokenModelByCachce(key);
    	if(tm==null){
    		return false;
    	}else{
    		return true;
    	}
    	
    }

    /**
     * 根据token字符串解析关键信息,得到key
     * @param tokenStr
     * @return
     */
    public String getKeyBytokenStr(String tokenStr){
    	
    	//解析过程，如果解析不了，key返回null
    	String key=tokenStr;//这里用userid做key
    	//m.put("userId", userId);
    		
    	return key;
    }
    
    
    /**
     * 根据key，从缓存中找到TokenModel对象
     * @param key
     * @return
     */
    public abstract TokenModel getTokenModelByCachce(String key);
    
    /**
     * 从字符串中解析token
     * @param authentication 加密后的字符串
     * @return
     */
/*	public TokenModel getToken(String tokenStr) {
		
		//1.解析tokenStr 生成数据如userid。
		
		//2.从
		if (tokenStr == null || tokenStr.length() == 0) {
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
        //TODO 抛出Token错误
        return new TokenModel(userId, token,null);
	}*/


    /**
     * 清除token
     * @param userId 登录用户的id
     */
    public  void deleteToken(String tokenStr){
    	
    	String key=getKeyBytokenStr(tokenStr);
    	deleteTokenByCache(key);
    	MDC.remove(KEY_USER);
    }
    
    public abstract void deleteTokenByCache(String key);

}
