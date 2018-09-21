package org.spring.springboot.orm.mybatis.pagehelper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PageService {

	@Autowired
	private PageMapper pageMapper;
	
	public List<PageObject> getList(int pageNum, int pageSize) throws Exception {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(pageNum, pageSize);
        //必须在PageHelper后紧跟 MyBatis 查询方法，这就是安全的。因为 PageHelper 在 finally 代码段中自动清除了 ThreadLocal 存储的对象
        List<PageObject> pageList = pageMapper.selectAll();
        return pageList;
    }
	
	public PageInfo<PageObject>  getList2(int pageNum, int pageSize) throws Exception {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(pageNum, pageSize);
        
        List<PageObject> countryList = pageMapper.selectAll();
        return new PageInfo<PageObject>(countryList);
    }
	
	//测试联表分页查询
	public List<OrderInfo> getList3(int pageNum, int pageSize,String poid) throws Exception {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(pageNum, pageSize);
        //必须在PageHelper后紧跟 MyBatis 查询方法，这就是安全的。因为 PageHelper 在 finally 代码段中自动清除了 ThreadLocal 存储的对象
        List<OrderInfo> pageList = pageMapper.selectOrderInfo(poid);
        return pageList;
    }
	
}
