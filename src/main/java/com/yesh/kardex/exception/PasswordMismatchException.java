package com.yesh.kardex.exception;

@SuppressWarnings("serial")
public class PasswordMismatchException extends RuntimeException {

	public PasswordMismatchException(String errorMessage) {
		super(errorMessage);
	}
}