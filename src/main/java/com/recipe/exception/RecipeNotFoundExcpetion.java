package com.recipe.exception;

public class RecipeNotFoundExcpetion extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RecipeNotFoundExcpetion(String message) {
		super(message);
	}

}
