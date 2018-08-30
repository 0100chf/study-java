package org.spring.springboot.mybatis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springboot.Application;
import org.spring.springboot.orm.mybatis.mapper.genid.User;
import org.spring.springboot.orm.mybatis.mapper.genid.User2;
import org.spring.springboot.orm.mybatis.mapper.genid.UserGenIdMapper;
import org.spring.springboot.orm.mybatis.mapper.genid.UserGenIdMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试Mapper插件UUID生成方式
 * @author chen haifeng
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Application.class)
@Transactional
public class GenidTest {
	
	@Autowired
	private UserGenIdMapper userMapper;
	
	@Autowired
	private UserGenIdMapper2 userMapper2;
	@Test
	@Rollback(value=false)
	public void test() throws Exception {
		User user1=new User("AA","001");
		userMapper.insert(user1);
		Assert.assertNotNull(user1.getId());
		User user2=new User("BB","002");
		userMapper.insert(user2);
		Assert.assertNotNull(user2.getId());
		User user3=new User("CC","003");
		userMapper.insert(user3);
		Assert.assertNotNull(user3.getId());
		User user4=new User("DD","004");
		userMapper.insert(user4);
		Assert.assertNotNull(user4.getId());
		User user5=new User("EE","005");
		userMapper.insert(user5);
		Assert.assertNotNull(user5.getId());
		
		
	}
	
	@Test
	@Rollback(value=false)
	public void test2() throws Exception {
		User2 user1=new User2("AA","001");
		userMapper2.insert(user1);
		Assert.assertNotNull(user1.getId());
		User2 user2=new User2("BB","002");
		userMapper2.insert(user2);
		Assert.assertNotNull(user2.getId());
		User2 user3=new User2("CC","003");
		userMapper2.insert(user3);
		Assert.assertNotNull(user3.getId());
		User2 user4=new User2("DD","004");
		userMapper2.insert(user4);
		Assert.assertNotNull(user4.getId());
		User2 user5=new User2("EE","005");
		userMapper2.insert(user5);
		Assert.assertNotNull(user5.getId());
		
	}
}
