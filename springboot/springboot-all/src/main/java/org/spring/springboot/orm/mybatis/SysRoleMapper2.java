package org.spring.springboot.orm.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysRoleMapper2 {

	//用驼峰式命名属性和字段映射
	SysRole  selectByid(Long  id) ;
	
	//用resultMap直接映射
	SysRole  selectByid2(Long  id) ;
	
	List<SysRole>  selectAll() ;
	
	List<SysRole>  selectAll2() ;
	
	
	/**
	 * 根据用户 id 和 角色的 enabled 状态获取用户的角色
	 * 
	 * @param userId
	 * @param enabled
	 * @return
	 */
	List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId")Long userId, @Param("enabled")Integer enabled);
	
	
	/**
	 * 根据用户 id 和 角色的 enabled 状态获取用户的角色
	 * 传参为类
	 * @param user
	 * @param role
	 * @return
	 */
	List<SysRole> selectRolesByUserAndRole(@Param("user")User user, @Param("role")SysRole role);
	
}
