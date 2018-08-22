package org.spring.springboot.jpa;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springboot.Application;
import org.spring.springboot.orm.jpa.User;
import org.spring.springboot.orm.jpa.UserCrudRepository;
import org.spring.springboot.orm.jpa.UserJpaRepository;
import org.spring.springboot.orm.jpa.UserPagingAndSortingRepository;
import org.spring.springboot.orm.jpa.UserRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Application.class)
public class JpaTests {

	@Autowired
	private UserCrudRepository userCrudRepository;

	
	@Autowired
	private UserRepository2 userRepository2;
	@Autowired
	private UserPagingAndSortingRepository userPagingAndSortingRepository;
	
	@Autowired
	private UserJpaRepository userJpaRepository;
	
	@Test
	public void testCrudRepository() throws Exception {

		//删除所有
		userCrudRepository.deleteAll();
		
		//save()方法是CrudRepository接口自带方法
		// 创建10条记录
		userCrudRepository.save(new User("AAA", 10));
		userCrudRepository.save(new User("BBB", 20));
		userCrudRepository.save(new User("CCC", 30));
		userCrudRepository.save(new User("DDD", 40));
		userCrudRepository.save(new User("EEE", 50));
		userCrudRepository.save(new User("FFF", 60));
		userCrudRepository.save(new User("GGG", 70));
		userCrudRepository.save(new User("HHH", 80));
		userCrudRepository.save(new User("III", 90));
		userCrudRepository.save(new User("JJJ", 100));
		
		// 测试findAll, 查询所有记录，CrudRepository接口自带count()方法
		Assert.assertEquals(10, userCrudRepository.count());
		
		// 测试findByName, 查询姓名为FFF的User
		Assert.assertEquals(60, userCrudRepository.findByName("FFF").getAge().longValue());

		Assert.assertEquals(60, userRepository2.findByName("FFF").getAge().longValue());
		
		// 测试findUser, 查询姓名为FFF的User
		Assert.assertEquals(60, userCrudRepository.searchUser("FFF").getAge().longValue());
		Assert.assertEquals(60, userRepository2.searchUser("FFF").getAge().longValue());
		
		// 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
		Assert.assertEquals("FFF", userCrudRepository.findByNameAndAge("FFF", 60).getName());
		Assert.assertEquals("FFF", userRepository2.findByNameAndAge("FFF", 60).getName());
		
		// 测试删除姓名为AAA的User,CrudRepository自带delete()方法
		userCrudRepository.delete(userCrudRepository.findByName("AAA"));
		
		// 测试findAll, 查询所有记录, 验证上面的删除是否成功
		Assert.assertEquals(9, userCrudRepository.count());
		
		//测试分页
		
		 Sort sort = new Sort(Direction.DESC, "id");
	     Pageable pageable = new PageRequest(1, 3, sort);
	     Page<User> pu= userPagingAndSortingRepository.findByDeletedFalse(pageable);
	     for(User u:pu){
	    	 System.out.println("id:"+u.getId()+";name:"+u.getName());
	     }
	     Assert.assertEquals(3, pu.getTotalPages());
	     
	     //测试JpaRepository的flush，没有发现有什么特殊功能
	     userJpaRepository.save(new User("KKK", 11));
	     Assert.assertEquals(10, userJpaRepository.count());
	    userJpaRepository.saveAndFlush(new User("LLL", 22));
	    Assert.assertEquals(11, userJpaRepository.count());
	    
	    //测试JpaRepository的分页
	    pu=userJpaRepository.findAll(pageable);
	     for(User u:pu){
	    	 System.out.println("id:"+u.getId()+";name:"+u.getName());
	     }
	     Assert.assertEquals(4, pu.getTotalPages());
	}


}
