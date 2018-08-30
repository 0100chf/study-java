package org.spring.springboot.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springboot.Application;
import org.spring.springboot.orm.mybatis.SysRole;
import org.spring.springboot.orm.mybatis.SysRoleMapper;
import org.spring.springboot.orm.mybatis.SysRoleMapper2;
import org.spring.springboot.orm.mybatis.User;
import org.spring.springboot.orm.mybatis.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试Mybatis原生API
 * @author chen haifeng
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Application.class)
@Transactional
public class MybatisTests {

	@Autowired
	private UserMapper userMapper;
	
	
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Autowired
	private SysRoleMapper2 sysRoleMapper2;
	
	@Test
	public void testSysRoleMapper() throws Exception {
		
		SysRole r=sysRoleMapper.selectByid(1L);
		System.out.println("roleName:"+r.getRoleName());
		Assert.assertEquals("管理员", r.getRoleName());
		
		/*r=sysRoleMapper.selectByid2(2L);
		System.out.println("roleName:"+r.getRoleName());
		Assert.assertEquals("普通用户", r.getRoleName());*/
		
		SysRole r2=sysRoleMapper2.selectByid(2L);
		System.out.println("roleName:"+r2.getRoleName());
		Assert.assertEquals("普通用户", r2.getRoleName());
		
		r2=sysRoleMapper2.selectByid2(1L);
		System.out.println("roleName:"+r2.getRoleName());
		Assert.assertEquals("管理员", r2.getRoleName());
		
		List<SysRole> sysRoleList=sysRoleMapper2.selectAll();
		System.out.println("sysRoleList size:"+sysRoleList.size());
		Assert.assertNotNull(sysRoleList.size());
		
		List<SysRole> sysRoleList2=sysRoleMapper2.selectAll2();
		System.out.println("sysRoleList2 size:"+sysRoleList2.size());
		Assert.assertNotNull(sysRoleList2.size());
		
		List<SysRole> sysRoleList3=sysRoleMapper2.selectRolesByUserIdAndRoleEnabled(1L, 1);
		for(SysRole s:sysRoleList3){
			System.out.println("rolename:"+s.getRoleName()+"");
		}
		Assert.assertNotNull(sysRoleList3.size());
		
		
		User user=new User();
		user.setId(1L);
		
		List<SysRole> sysRoleList4=sysRoleMapper2.selectRolesByUserAndRole(user, r);
		for(SysRole s:sysRoleList4){
			System.out.println("rolename:"+s.getRoleName()+"");
		}
		Assert.assertNotNull(sysRoleList4.size());
	}
	
	//@Test
	//@Rollback(value=false)//junit默认是回滚的
	public void testUserMapper() throws Exception {
		// insert一条数据，并select出来验证
		userMapper.insert("AAA", 20);
		User u = userMapper.findByName("AAA");
		Assert.assertEquals(20, u.getAge().intValue());
		// update一条数据，并select出来验证
		u.setAge(30);
		userMapper.update(u);
		u = userMapper.findByName("AAA");
		Assert.assertEquals(30, u.getAge().intValue());
		// 删除这条数据，并select验证
		userMapper.delete(u.getId());
		u = userMapper.findByName("AAA");
		Assert.assertEquals(null, u);

		u = new User("BBB", 30);
		userMapper.insertByUser(u);
		Assert.assertEquals(30, userMapper.findByName("BBB").getAge().intValue());

		Map<String, Object> map = new HashMap<>();
		map.put("name", "CCC");
		map.put("age", 40);
		userMapper.insertByMap(map);
		Assert.assertEquals(40, userMapper.findByName("CCC").getAge().intValue());

		List<User> userList = userMapper.findAll();
		for(User user : userList) {
			Assert.assertEquals(null, user.getId());
			Assert.assertNotEquals(null, user.getName());
		}
	}

}
