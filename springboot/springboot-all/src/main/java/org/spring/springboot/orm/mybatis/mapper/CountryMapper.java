package org.spring.springboot.orm.mybatis.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import tk.mybatis.mapper.common.Mapper;

/**
 * 注解方式和xml方式可以混合一起用
 * @author chen haifeng
 *
 */
public interface  CountryMapper extends Mapper<MapperCountry>{

	 @Select("select * from MapperCountry where countryname = #{countryname}")
	 MapperCountry selectByCountryName(String countryname);
	 
	 MapperCountry selectByCountryCode(String countrycode);
	 
	 List<MapperCountry> selectAll(RowBounds rowBounds);
}
