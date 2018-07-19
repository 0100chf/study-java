package org.spring.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.xiaowenjie.common.authorization.model.BaseUser;
import lombok.Data;

/**
 * 用户数据的domain类
 * @author ScienJus
 * @date 2015/7/31.
 */
@Data
@Entity
@Table(name = "user_")
public class User extends BaseUser{


    //昵称
    @Column(name = "nickname")
    private String nickname;

}
