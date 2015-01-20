package com.general.utils;

public class CustomException extends Exception{

	
	private String key;
	
	
public CustomException(){}
	

	public CustomException(String key) {
	super();
	this.key = key;
}


	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
