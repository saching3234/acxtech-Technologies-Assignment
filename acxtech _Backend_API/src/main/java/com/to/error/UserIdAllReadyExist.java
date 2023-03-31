package com.to.error;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserIdAllReadyExist extends Exception{
	public UserIdAllReadyExist() {
		super();
	}
	
	public UserIdAllReadyExist(String msg) {
		super(msg);
		log.info("User Id Allready taken please try with other usere id......");
		
	}

}
