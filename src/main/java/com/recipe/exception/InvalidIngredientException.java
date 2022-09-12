package com.recipe.exception;

public class InvalidIngredientException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public InvalidIngredientException(String message) {
		super(message);
	}

}
