package org.spring.springboot.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

import org.spring.springboot.common.utils.CheckUtil;

/**
 * 工具类(静态类)的注入
 * 
 */
@Configuration
public class StaticFieldConfig {

	@Autowired
	MessageSource resources;


	@PostConstruct
	private void init() {
		CheckUtil.setResources(resources);

	}
}