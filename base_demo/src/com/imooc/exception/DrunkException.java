package com.imooc.exception;

/**
 * 自定义异常(编写一个自定义异常)
 * @author 君宇
 *
 */
public class DrunkException extends Exception {
	
	public DrunkException(){
		
	}
	
	public DrunkException(String message){
		super(message);
	}

}
