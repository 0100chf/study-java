package org.spring.springboot.orm.jpa;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserJpaRepository extends JpaRepository<User, Integer> {

}
