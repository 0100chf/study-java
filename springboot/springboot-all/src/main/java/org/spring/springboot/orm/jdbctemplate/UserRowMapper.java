package org.spring.springboot.orm.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * 通过RowMapper来ORM实体User
 * @author chen haifeng
 *
 */
public class UserRowMapper implements RowMapper<User>{

	/**
	 * rs:结果集.
	 * rowNum:行号
	 */
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setAge(rs.getInt("age"));
		return user;

	}

}
