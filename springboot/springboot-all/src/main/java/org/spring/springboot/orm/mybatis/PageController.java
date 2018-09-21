package org.spring.springboot.orm.mybatis;

import java.util.List;

import org.spring.springboot.orm.mybatis.mapper.CountryService;
import org.spring.springboot.orm.mybatis.mapper.MapperCountry;
import org.spring.springboot.orm.mybatis.pagehelper.OrderInfo;
import org.spring.springboot.orm.mybatis.pagehelper.PageObject;
import org.spring.springboot.orm.mybatis.pagehelper.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

//pagehelper使用
//http://localhost:8080/pagetest/getList2?pageNum=2&pageSize=6
//http://localhost:8080/pagetest/getList?pageNum=2&pageSize=6
//pagehelper 联表查询使用
//http://localhost:8080/pagetest/getList3?pageNum=1&pageSize=3&poid=po2

//通用mapper和pagehelper联用：
//http://localhost:8080/pagetest/getCountryList?pageNum=2&pageSize=3
//http://localhost:8080/pagetest/getCountryList2?pageNum=2&pageSize=3

@RestController
@RequestMapping("/pagetest")
public class PageController {
	
	@Autowired
	private PageService pageService;
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping(value = "/getList")
	public List<PageObject> getList(int pageNum, int pageSize) throws Exception {
        // 调用业务逻辑,返回数据
        return pageService.getList(pageNum,pageSize);
    }
	
	
	@RequestMapping(value = "/getList2")
	public PageInfo<?> getList2(int pageNum, int pageSize) throws Exception {
        // 调用业务逻辑,返回数据
        return pageService.getList2(pageNum,pageSize);
    }
	
	@RequestMapping(value = "/getList3")
	public  List<OrderInfo> getList3(int pageNum, int pageSize,String poid) throws Exception {
        // 调用业务逻辑,返回数据
        return pageService.getList3(pageNum,pageSize,poid);
    }
	
	
	@RequestMapping(value = "/getCountryList")
	public List<MapperCountry> getCountryList(int pageNum, int pageSize) throws Exception {
        // 调用业务逻辑,返回数据
        return countryService.getList(pageNum,pageSize);
    }
	
	@RequestMapping(value = "/getCountryList2")
	public PageInfo<?> getCountryList2(int pageNum, int pageSize) throws Exception {
        // 调用业务逻辑,返回数据
        return countryService.getList2(pageNum,pageSize);
    }
}
