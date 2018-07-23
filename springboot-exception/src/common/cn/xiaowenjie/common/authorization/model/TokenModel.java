package cn.xiaowenjie.common.authorization.model;

import java.io.Serializable;

import lombok.Data;

/**
 * Token的Model类，可以增加字段提高安全性，例如时间戳、url签名
 * @author ScienJus
 * @date 2015/7/31.
 */

@Data
public class TokenModel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1678904496256122864L;

	//用户id
    private String userId;

    //用户帐号或名字
    private String account;
    
    //用户名字
    private String name;
    
    //用户其他信息
    private Object data;
    
    //由key来找到缓存里面对应的TokenModel对象
    private String key;
}
