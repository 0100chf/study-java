package cn.ks0100.common.result;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Data;

@Data
public class ResultBean<T> extends ResponseEntity<T>{


	private T data;//成功后返回的数据或ResultStatus
	
	public ResultBean(T body,HttpStatus status) {
		super(body,status);
		this.data = body;
	}
	
	public ResultBean(T body) {
		this(body,HttpStatus.OK);
	}
	

	
	

}
