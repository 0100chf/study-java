package cn.xiaowenjie.common.authorization.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户的基类，必备字段id、名称/帐号、密码
 * 
 */
@Data
@MappedSuperclass
@EqualsAndHashCode(of = "id")
public abstract class BaseUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7535331011635183171L;

	@Id
	@GeneratedValue
	private String id;

	private String username;
	 
    private String password;


}
