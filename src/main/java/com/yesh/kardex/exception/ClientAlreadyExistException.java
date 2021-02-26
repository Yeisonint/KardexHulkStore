package com.yesh.kardex.exception;

@SuppressWarnings("serial")
public class ClientAlreadyExistException extends RuntimeException {

	public ClientAlreadyExistException(String errorMessage) {
		super(errorMessage);
	}
}