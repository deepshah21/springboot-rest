package com.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExcpetion extends RuntimeException {

	public UserNotFoundExcpetion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundExcpetion(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundExcpetion(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundExcpetion(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundExcpetion(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	
}
