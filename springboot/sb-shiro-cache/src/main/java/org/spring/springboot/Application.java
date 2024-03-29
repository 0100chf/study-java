package org.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring Boot 应用启动类
 */
@SpringBootApplication
@EnableCaching
@ComponentScan(
	basePackages={"cn.ks0100.common","org.spring.springboot"}
	)
public class Application {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        
    	SpringApplication.run(Application.class,args);
    	//printBeans(SpringApplication.run(Application.class,args));
    }
    
    private static void printBeans(ApplicationContext  ctx){
    	String[] beanNames =  ctx.getBeanDefinitionNames();

        System.out.println("所以beanNames个数："+beanNames.length);

        for(String bn:beanNames){

            System.out.println(bn);

        }
    }
}
