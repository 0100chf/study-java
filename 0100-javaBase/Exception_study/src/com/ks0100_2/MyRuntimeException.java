package com.ks0100_2;

public class MyRuntimeException extends RuntimeException{
	public MyRuntimeException(String message){
		super(message);
		System.out.println(message);
	}
}
