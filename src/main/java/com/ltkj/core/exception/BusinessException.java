package com.ltkj.core.exception;

public class BusinessException extends Exception{
	private static final long serialVersionUID = 1L;
	
	//异常信息
	public String message;
	
	public BusinessException(String message){
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
