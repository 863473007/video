package com.zhiyou.exception;

public class MyException extends Exception{

	private String message;
	
    public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public MyException(){
		super();
	}
	public MyException(String message){
		this.message =message;
	}
}
