package org.spring.springboot.orm.mybatis.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * mapper和pagehelper 结合使用
 * @author chen haifeng
 *
 */
@Service
public class CountryService {
	
	@Autowired
	private CountryMapper countryMapper;
	
	//通用mapper和pagehelper联用
	public List<MapperCountry> getList(int pageNum, int pageSize) throws Exception {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(pageNum, pageSize);
        //必须在PageHelper后紧跟 MyBatis 查询方法，这就是安全的。因为 PageHelper 在 finally 代码段中自动清除了 ThreadLocal 存储的对象
        List<MapperCountry> pageList = countryMapper.selectAll();
        return pageList;
    }
	
	public PageInfo<MapperCountry>  getList2(int pageNum, int pageSize) throws Exception {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(pageNum, pageSize);
        
        List<MapperCountry> countryList = countryMapper.selectAll();
        return new PageInfo<MapperCountry>(countryList);
    }
}
