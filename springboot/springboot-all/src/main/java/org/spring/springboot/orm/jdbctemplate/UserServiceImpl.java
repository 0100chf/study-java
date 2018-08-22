package org.spring.springboot.orm.jdbctemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into JDBCTEMPLATE_USER(NAME, AGE) values(?, ?)", name, age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from JDBCTEMPLATE_USER where NAME = ?", name);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from JDBCTEMPLATE_USER", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from JDBCTEMPLATE_USER");
    }
    
    /**
     * jdbcTemplate.queryForObject()方法调用RowMapper实现类，来实现与User的映射
     */
	public User findById(int id){
		String sql = "select * from JDBCTEMPLATE_USER where id = ?";
		User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
		return user;
	}
	
    /**
     * jdbcTemplate.queryForObject()方法调用RowMapper实现类，来实现与List<User> 的映射
     */
	public List<User> findAll(){
		String sql = "select * from JDBCTEMPLATE_USER";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}


    /**
     * jdbcTemplate.query()方法调用BeanPropertyRowMapper，来实现与List<User> 的映射
     * 不用再写RowMapper实现类
     */
	public List<User> findAll2() {
	      return jdbcTemplate.query("select * from JDBCTEMPLATE_USER", new BeanPropertyRowMapper<User>(User.class));
	  }

	/*
	  * 解决多个sql的插入、更新、删除操作在一个Statement中。性能一般。
		jdbcTemplate.batchUpdate(String sql, final BatchPreparedStatementSetter pss),
		类似于JDBC的PreparedStatement，性能较上着有所提高
	  */
	public int createUserByBatch(int count) {

		final List<String> names = new ArrayList<String>(count);
		for (int i = 0; i < count; i++) {
			names.add("Name " + i);
		}
		jdbcTemplate.batchUpdate("insert into JDBCTEMPLATE_USER (id, name,age) values (?, ?,?)", new BatchPreparedStatementSetter() {
			// 为prepared statement设置参数。这个方法将在整个过程中被调用的次数
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, i+1);
				ps.setString(2, names.get(i));
				ps.setInt(3, i + 10);
			}

			// 返回更新的结果集条数
			public int getBatchSize() {
				return count;
			}
		});
		return count;
	}
	
	public int createUserByBatch2(int count) {
    	BatchInsert batchInsert=new BatchInsert(jdbcTemplate.getDataSource());
            for (int i = 0; i < count; i++) {  
              batchInsert.update(new Object[] { i + 10, "name" + i,  i+20 });  
            } 
         batchInsert.flush();//flush 才能提交到数据库
        return count;
    }


}
