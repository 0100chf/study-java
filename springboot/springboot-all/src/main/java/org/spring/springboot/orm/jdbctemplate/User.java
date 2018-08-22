package org.spring.springboot.orm.jdbctemplate;



/**
 *
CREATE TABLE
    JDBCTEMPLATE_USER
    (
        id INT NOT NULL AUTO_INCREMENT,
        age INT NOT NULL,
        name VARCHAR(255) NOT NULL,
        PRIMARY KEY (id)
    )
    ENGINE=InnoDB DEFAULT CHARSET=utf8;
 *
 */
public class User {

    private Integer id;
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String name;
    private Integer age;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
