package com.ks0100_2;

public class MyCheckedException extends Exception{
	 public MyCheckedException(String message) {
		 super(message);
		 System.out.println(message);
	 }
}
