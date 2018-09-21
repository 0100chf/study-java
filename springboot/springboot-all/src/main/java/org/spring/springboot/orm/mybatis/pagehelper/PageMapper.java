package org.spring.springboot.orm.mybatis.pagehelper;

import java.util.List;

public interface PageMapper {
	List<PageObject> selectAll();
	
	//联表分页查询
	List<OrderInfo> selectOrderInfo(String poid);
}
