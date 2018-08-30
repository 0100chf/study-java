package org.spring.springboot.orm.mybatis.mapper.genid;

import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.KeySql;

@Table(name="genid_user")
public class User {
	//使用java.util.UUID生成主键UUID
	@Id
    @KeySql(genId = UUIdGenId.class)
    private String id;
    private String name;
    private String code;

    public User() {
    }

    public User(String name, String code) {
        this.name = name;
        this.code = code;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
    
}
