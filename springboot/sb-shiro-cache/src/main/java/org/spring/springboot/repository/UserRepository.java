package org.spring.springboot.repository;

import org.spring.springboot.model.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * User类的CRUD操作
 * @see com.scienjus.domain.User
 * @author ScienJus
 * @date 2015/7/10.
 */
public interface UserRepository  extends CrudRepository<UserInfo, String>    {

	 public UserInfo findByUsername(String username);
}
