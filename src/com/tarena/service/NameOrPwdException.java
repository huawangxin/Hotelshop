package com.tarena.service;
/*用户名或密码错误*/
public class NameOrPwdException extends Exception {
	public NameOrPwdException(){
		
	}
	public NameOrPwdException(String message){
		super(message);
	}
	public NameOrPwdException(Throwable cause){
		super(cause);
	}
	public NameOrPwdException(String message,Throwable cause){
		super(message,cause);
	}
}
