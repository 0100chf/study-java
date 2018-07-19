package cn.xiaowenjie.common.result;

import lombok.Data;

@Data
public class ResultStatus {
	
	public static final int SUCCESS = 0;

	public static final int FAIL = 1;
	
	public static final int NO_LOGIN = 2;

	public static final int NO_PERMISSION = 403;
	
	public static final int NO_FOUND = 404;

	private String msg = "success";//成功或异常信息

	private int errorCode = SUCCESS;
	
	private Object data;
	public ResultStatus(){
		
	}
	
	public ResultStatus(Object data){
		this.data=data;
		this.errorCode=SUCCESS;
		this.msg="success";
	}
	public ResultStatus(String msg ,int code ){
		this.msg=msg;
		this.errorCode=code;
	}
}
