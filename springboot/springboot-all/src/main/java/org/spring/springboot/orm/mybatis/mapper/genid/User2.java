package org.spring.springboot.orm.mybatis.mapper.genid;

import javax.persistence.Id;
import javax.persistence.Table;

import tk.mybatis.mapper.annotation.KeySql;

@Table(name="genid_user2")
public class User2 {
	//通过同步方法，生成数字UUID
	@Id
    @KeySql(genId = SimpleGenId.class)
    private Long  id;
    private String name;
    private String code;

    public User2() {
    }

    public User2(String name, String code) {
        this.name = name;
        this.code = code;
    }



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
