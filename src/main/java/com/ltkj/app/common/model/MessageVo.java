package com.ltkj.app.common.model;

import java.io.Serializable;
import java.util.List;

public class MessageVo implements Serializable {
	private static final long serialVersionUID = -8828623179645036498L;
	
	//是否是错误
	private boolean isError;
	
	//错误code
	private String errorCode;
	
	//错误信息
	private String message;
	
	//错误信息集合
	private List<String> messages;
	
	private Object obj;
	
	//构造方法
	public MessageVo() {
		// TODO Auto-generated constructor stub
	}
	
	public MessageVo(String message) {
		this.isError = false;
		this.message = message;
	}
	
	public MessageVo(String message,Object obj) {
		this.isError = false;
		this.message = message;
		this.obj = obj;
	}
	
	public MessageVo(boolean isError) {
		this.isError = isError;
	}
	
	public MessageVo(boolean isError,String message) {
		this.isError = isError;
		this.message = message;
	}
	
/*	public MessageVo(String errorCode, String message) {
		this.isError = true;
		this.errorCode = errorCode;
		this.message = message;
	}*/
	
	public MessageVo(boolean isError,String message,Object obj) {
		this.isError = isError;
		this.message = message;
		this.obj = obj;
	}
	
	public MessageVo(boolean isError,List<String> messages) {
		this.isError = isError;
		this.messages = messages;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
