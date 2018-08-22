package org.spring.springboot.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class UserInfo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -440859312048798108L;
	@Id
    @GeneratedValue
    private String uid;
    @Column(unique =true)
    private String username;//帐号
    private String name;//名称（昵称或者真实姓名，不同系统不同定义）
    private String password; //密码;
    private String salt;//加密密码的盐
    private byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
    //@ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @ManyToMany
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> roleList;// 一个用户具有多个角色

   

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
      //  return this.username+this.salt;
    	return "admin"+this.salt;//只是为了vip用户也能使用admin的密码。
    }
    //重新对盐重新进行了定义，用户名+salt，这样就更加不容易被破解
}