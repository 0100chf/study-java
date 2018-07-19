package cn.xiaowenjie.common.authorization.model;

import lombok.Data;

/**
 * Token的Model类，可以增加字段提高安全性，例如时间戳、url签名
 * @author ScienJus
 * @date 2015/7/31.
 */

@Data
public class TokenModel {

    //用户id
    private String userId;

    //随机生成的uuid
    private String token;

    //用户帐号或名字
    private String userName;
    
    public TokenModel(String userId, String token,String userName) {
        this.userId = userId;
        this.token = token;
        this.userName=userName;
    }

}
