package com.recipe.exception;

public class LogNotFoundExcpetion extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public LogNotFoundExcpetion(String message) {
		super(message);
	}

}
