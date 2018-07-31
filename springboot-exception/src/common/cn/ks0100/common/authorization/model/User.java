package cn.ks0100.common.authorization.model;

import lombok.Getter;
import lombok.Setter;

/**
 * 该对象主要包含用户名密码
 * @author chen haifeng
 *
 */
@Setter
@Getter
public class User {
	private String userId;
	private String account;
	private String password;
}
