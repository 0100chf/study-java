package org.spring.springboot.jdbctemplate;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springboot.Application;
import org.spring.springboot.orm.jdbctemplate.User;
import org.spring.springboot.orm.jdbctemplate.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Application.class)
public class JdbctemplateTests {

	@Autowired
	private UserService userSerivce;

	@Before
	public void setUp() {
		// 准备，清空user表
		userSerivce.deleteAllUsers();
	}

	@Test
	public void test() throws Exception {
		// 插入5个用户
		userSerivce.create("a", 1);
		userSerivce.create("b", 2);
		userSerivce.create("c", 3);
		userSerivce.create("d", 4);
		userSerivce.create("e", 5);

		// 查数据库，应该有5个用户
		Assert.assertEquals(5, userSerivce.getAllUsers().intValue());

		// 删除两个用户
		userSerivce.deleteByName("a");
		userSerivce.deleteByName("e");

		// 查数据库，应该有5个用户
		Assert.assertEquals(3, userSerivce.getAllUsers().intValue());
		
		//测试 RowMapper
		List<User> userList=userSerivce.findAll();
		Assert.assertEquals(3, userList.size());
		User user=null;
		for(User u:userList){
			if(u.getName().equals("b")){
				user=u;
				break;
			}
		}
		User user2=userSerivce.findById(user.getId());
		Assert.assertEquals("b",user2.getName());

		//测试 BeanPropertyRowMapper
		List<User> userList2=userSerivce.findAll2();
		Assert.assertEquals(3, userList2.size());
		
		// 准备，清空user表
		userSerivce.deleteAllUsers();
		//测试批量插入createUserByBatch
		userSerivce.createUserByBatch(10);
		userList=userSerivce.findAll();
		Assert.assertEquals(10, userList.size());
		
		// 准备，清空user表
		userSerivce.deleteAllUsers();
		//测试批量插入createUserByBatch2
		userSerivce.createUserByBatch2(5);
		userList=userSerivce.findAll();
		Assert.assertEquals(5, userList.size());
	}
	
	

}
