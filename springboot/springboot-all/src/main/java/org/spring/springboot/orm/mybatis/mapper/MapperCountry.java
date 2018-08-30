package org.spring.springboot.orm.mybatis.mapper;

import javax.persistence.Id;

import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

/**
 * Mapper默认用的是camelhump风格（即驼峰转下划线）。用@NameStyle改为normal风格（原值方式，表名和类名一致），
 * 或用@Table 注解修改
 * 也可以在application.properties统一修改。
 * @author chen haifeng
 *
 */
//
@NameStyle(Style.normal)
public class MapperCountry {
	 @Id
	 private Integer id;
	 private String  countryname;
	 private String  countrycode;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountryname() {
		return countryname;
	}
	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	 
	 
}
