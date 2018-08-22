package org.spring.springboot.orm.jdbctemplate;

import java.util.List;

public interface  UserService {
	/**
     * 新增一个用户
     * @param name
     * @param age
     */
    void create(String name, Integer age);

    /**
     * 根据name删除一个用户高
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();

    /**
     * 通过调用RowMapper实现类，来实现与User的映射
     * @param id
     * @return
     */
    public User findById(int id);
    
    /**
     * 通过调用RowMapper实现类，来实现与User的映射
     * @return
     */
    public List<User> findAll();
    
    /**
     * 通过调用BeanPropertyRowMapper，来实现与User的映射,
     * 不用再写RowMapper实现类
     * @return
     */
    public List<User> findAll2() ;
    
    /**
     * 采用jdbcTemplate.batchUpdate()来批量插入
     * @param count
     * @return
     */
    public int createUserByBatch(int count) ;
    
    /**
     * 继承BatchSqlUpdate类来批量插入，参考BatchInsert 
     * @param count
     * @return
     */
    public int createUserByBatch2(int count) ;
}
