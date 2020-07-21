package com.exerate.ui.exceptions;

public class UserServiceException extends RuntimeException{

	private static final long serialVersionUID = 7296297399466672789L;

	public UserServiceException(String message) {
		super(message);
	}
}
