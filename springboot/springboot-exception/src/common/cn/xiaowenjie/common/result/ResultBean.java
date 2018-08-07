package cn.xiaowenjie.common.result;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResultBean<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	
	public static final int NO_LOGIN = -1;

	public static final int SUCCESS = 0;

	public static final int FAIL = 1;

	public static final int NO_PERMISSION = 403;
	
	public static final int NO_FOUND = 404;

	private String msg = "success";//成功或异常信息

	private int code = SUCCESS;

	private T data;//成功后返回的数据

	public ResultBean() {
		super();
	}

	public ResultBean(T data) {
		super();
		this.data = data;
	}

	public ResultBean(Throwable e) {
		super();
		this.msg = e.toString();
		this.code = FAIL;
	}
	
	public ResultBean(String msg,int code) {
		super();
		this.msg = msg;
		this.code = code;
	}
}
