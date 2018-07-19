package org.spring.springboot.repository;

import org.spring.springboot.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * User类的CRUD操作
 * @see com.scienjus.domain.User
 * @author ScienJus
 * @date 2015/7/10.
 */
public interface UserRepository  extends CrudRepository<User, String>    {

	 public User findByUsername(String username);
}
