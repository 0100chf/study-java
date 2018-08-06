package cn.ks0100.common.result;

import org.springframework.http.HttpStatus;

import cn.ks0100.common.utils.CheckUtil;
import cn.ks0100.common.utils.LocalUtil;
import lombok.Data;

@Data
public class ResultStatus {
	
	public static final int SUCCESS = 0;

	public static final int FAIL = 1;
	
	public static final int NO_LOGIN = 2;

	public static final int INCORRECT_LOGIN = 3;
	
	public static final int VERICODE_ERROR = 4;
	
	public static final int NO_PERMISSION = 401;
	
	public static final int NO_FOUND = 404;

	private String msg = "success";//成功或异常信息

	private int msgCode = SUCCESS;
	
	private Object data;
	public ResultStatus(){
		
	}
	
	public ResultStatus(Object data){
		this.data=data;
		this.msgCode=SUCCESS;
		this.msg="success";
	}
	public ResultStatus(String msg ,int code ){
		this.msg=msg;
		this.msgCode=code;
	}
	
	
	public static ResultBean exceptionResult(int status){
		String errorMessage="";
		ResultBean r=null;
		switch (status) {
		case NO_FOUND://404接口错误
			errorMessage=CheckUtil.getResources().getMessage("interface.no.found",null, LocalUtil.getLocale());
			r=new ResultBean(new ResultStatus(errorMessage,ResultStatus.NO_FOUND),HttpStatus.NOT_FOUND);
			break;
		
		case NO_LOGIN://未登录
			errorMessage=CheckUtil.getResources().getMessage("user.not.login",null, LocalUtil.getLocale());
			r=new ResultBean(new ResultStatus(errorMessage,ResultStatus.NO_LOGIN),HttpStatus.UNAUTHORIZED);
			break;
			
		case NO_PERMISSION: //用户没有权限
			errorMessage=CheckUtil.getResources().getMessage("user.not.permission",null, LocalUtil.getLocale());
    		r=new ResultBean(new ResultStatus(errorMessage,ResultStatus.NO_PERMISSION),HttpStatus.UNAUTHORIZED);
    		break;
		
		case INCORRECT_LOGIN://帐号密码错误
			errorMessage=CheckUtil.getResources().getMessage("user.login.error",null, LocalUtil.getLocale());
			r=new ResultBean(new ResultStatus(errorMessage,ResultStatus.INCORRECT_LOGIN),HttpStatus.NOT_ACCEPTABLE);
			break;
		case VERICODE_ERROR://验证码错误
			errorMessage=CheckUtil.getResources().getMessage("user.login.vericode.error",null, LocalUtil.getLocale());
			r=new ResultBean(new ResultStatus(errorMessage,ResultStatus.VERICODE_ERROR),HttpStatus.NOT_ACCEPTABLE);
		default:
			break;
		}
		
		return r;
	}
	
	public static ResultBean exceptionResult(String exceptionStr){
		return new ResultBean(new ResultStatus(exceptionStr,ResultStatus.FAIL),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
