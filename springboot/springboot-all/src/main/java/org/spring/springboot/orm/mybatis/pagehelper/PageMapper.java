package org.spring.springboot.orm.mybatis.pagehelper;

import java.util.List;

public interface PageMapper {
	List<PageObject> selectAll();
}
