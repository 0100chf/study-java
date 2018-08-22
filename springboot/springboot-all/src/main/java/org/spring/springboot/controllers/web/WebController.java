package org.spring.springboot.controllers.web;

import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.spring.springboot.common.aop.WebControllerAnno;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/web")
@Controller
public class WebController {

	@Autowired
	private CityService cityService;
    
    
    @RequestMapping("/hello")
    @WebControllerAnno  //根据这个注解来做异常统一管理
    public String hello()    {
    	int i=1/0;
    	return "index";
    }
    
    //抛出自定义页面异常
    @RequestMapping("/hello1")
    @WebControllerAnno
    public String hello1() throws Exception  {
    	
		//在页面方法中返回自定义异常
		throw new Exception("自定义异常");
    }
    
    @RequestMapping("/hello2")
    @WebControllerAnno
    public String hello2(@RequestParam("cityName") String cityName) {
    	
    	cityService.getCity(cityName);
    	return "index";
    }
    
   @RequestMapping(value = "/index2",method = RequestMethod.GET)
    @ApiOperation(value = "访问首页")
     @ApiImplicitParams({
             @ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"),
     })
    public String index() {
   	   return "index";
   }
   
   
   
}