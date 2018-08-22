package org.spring.springboot.orm.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User, Integer>{
	//注意User表有deleted=false
		Page<User> findByDeletedFalse(Pageable pageable);
}
