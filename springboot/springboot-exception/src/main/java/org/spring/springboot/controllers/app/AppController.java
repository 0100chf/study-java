package org.spring.springboot.controllers.app;

import org.spring.springboot.model.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.xiaowenjie.common.result.ResultBean;

@RequestMapping("/app")
@RestController
public class AppController{

	@Autowired
	private CityService cityService;
	
/*    @RequestMapping(value = "/city", method = RequestMethod.GET)
    public ResultBody findOneCity(@RequestParam("cityName") String cityName) throws AppException {
        // 入参为空
        if (StringUtils.isEmpty(cityName)) {
        	//抛出业务异常，参数必填，返回json
            throw new AppException(CityErrorInfoEnum.PARAMS_NO_COMPLETE);
        }else if(StringUtils.pathEquals(cityName, "上海")){ 
        	//抛出业务异常，城市不存在，返回json
        	 throw new AppException(CityErrorInfoEnum.CITY_EXIT);
        }else if(StringUtils.pathEquals(cityName, "北京")){
        	//产生异常，返回json
        	int i=1/0;
        }
        return new ResultBody(new City(1L,2L,"温岭","是我的故乡"));
    }*/
    
    
    
    @RequestMapping(value = "/city3", method = RequestMethod.GET)
    public ResultBean<City> findOneCity3(@RequestParam("cityName") String cityName) {
    	
    	return new ResultBean<City>(cityService.getCity(cityName));
    }
}
