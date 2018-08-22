package org.spring.springboot.orm.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 在注解上写sql语句
 * @author chen haifeng
 *
 */
@Mapper
public interface SysRoleMapper {

	@Select  ({ "select  id , role_name  roleName, enabled,create_by  createBy ,"
				+"create_time  createTime "
				+"from  MYBATIS_ROLE "
				+"where  id= #{id} "})
	SysRole  selectByid(Long  id) ;
	
	/**
	 * 需要配置mybatis.configuration.map-underscore-to-camel-case=true
	 * 可以自动将用下划线方式命名的数据库字段（列）映射到Java类的驼峰式命名属性中
	 */
	@Select  ({ "select  id , role_name , enabled,create_by  ,create_time "
				+"from  MYBATIS_ROLE where id=#{id} "})
	SysRole  selectByid2(Long  id) ;
}
