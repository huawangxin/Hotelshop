package com.tarena.service;
/*����Ϊ��*/
public class NullParamException extends Exception {
	public NullParamException(){
		
	}
	public NullParamException(String message){
		super(message);
	}
	public NullParamException(Throwable cause){
		super(cause);
	}
	public NullParamException(String message,Throwable cause){
		super(message, cause);
	}
}
