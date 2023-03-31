package com.to.error;

public class InvalidUserNamePasswordException extends RuntimeException{ 
	//default constructor
	  public InvalidUserNamePasswordException() {
		super();
	}
	  
	public InvalidUserNamePasswordException(String message) {
		super(message);
	}
	  
}
