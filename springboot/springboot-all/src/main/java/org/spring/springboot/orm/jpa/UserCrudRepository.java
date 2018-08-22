package org.spring.springboot.orm.jpa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * CrudRepository，它会自动为域对象提供了开箱即用的十个增删改查方法。
 * @author chen haifeng
 *
 */

@Transactional
public interface UserCrudRepository extends  CrudRepository<User, Long> {

    User findByName(String name);

    User findByNameAndAge(String name, Integer age);

    //:参数名 对应@Param("参数名") 
    @Query("from User u where u.name=:name")
    User searchUser(@Param("name") String name);

    //?+数字的方式代替参数
    @Query("from User u where u.name=?1")
    User searchUser2(String name);

    //@Query 也可以用来修改和删除等，加上@Modifying即可,并且要配上Repository接口配置事务
    @Modifying
    @Query("update User u set u.name = ?1 where u.id = ?2")
    public int  updateUser(String name, Integer id);
    
    //nativeQuery = true 使用原生sql
    @Query(value = "SELECT * FROM User WHERE name = ?1", nativeQuery = true)
    User searchByName(String name);
}
