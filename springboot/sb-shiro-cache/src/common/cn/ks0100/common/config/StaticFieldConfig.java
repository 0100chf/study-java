package cn.ks0100.common.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

import cn.ks0100.common.utils.CheckUtil;

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