package org.spring.springboot.mybatis;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springboot.Application;
import org.spring.springboot.orm.mybatis.mapper.CountryMapper;
import org.spring.springboot.orm.mybatis.mapper.MapperCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试使用Mapper插件
 * @author chen haifeng
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(Application.class)
@Transactional
public class MapperTest {

	@Autowired
	private CountryMapper countryMapper;
	
	@Test
	public void test() throws Exception{
		//从 MyBatis 或者 Spring 中获取 countryMapper，然后调用 selectAll 方法
		List<MapperCountry> countries = countryMapper.selectAll();
		Assert.assertEquals(7,countries.size());
		MapperCountry last=countries.get(6);
		//根据主键查询
		MapperCountry country = countryMapper.selectByPrimaryKey(last.getId());
		Assert.assertNotNull(country);
		//或者使用对象传参，适用于1个字段或者多个字段联合主键使用
		MapperCountry query = new MapperCountry();
		query.setCountryname("中国");
		country = countryMapper.selectOne(query);
		Assert.assertNotNull(country);
		
		country=countryMapper.selectByCountryName("美国");
		Assert.assertEquals("002",country.getCountrycode());
		
		country=countryMapper.selectByCountryCode("003");
		Assert.assertEquals("法国",country.getCountryname());
	}
}
