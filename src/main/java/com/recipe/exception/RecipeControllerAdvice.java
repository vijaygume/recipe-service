package com.recipe.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.recipe.model.ExceptionNotification;

@RestControllerAdvice
public class RecipeControllerAdvice {
	
	@ExceptionHandler(InvalidIngredientException.class)
	public ExceptionNotification handleInvalidIngredientException(HttpServletRequest req,InvalidIngredientException ex) {
		final ExceptionNotification notification = new ExceptionNotification();
		notification.setErrorCode("123");
		notification.setDescription(ex.getMessage());
		notification.setContextPath(req.getRequestURI());
		notification.setStatus(HttpStatus.BAD_REQUEST.name());
		return notification;
	}
	
	@ExceptionHandler(RecipeNotFoundExcpetion.class)
	public ExceptionNotification handleRecipeNotFoundExcpetion(HttpServletRequest req,RecipeNotFoundExcpetion ex) {
		final ExceptionNotification notification = new ExceptionNotification();
		notification.setErrorCode("125");
		notification.setDescription(ex.getMessage());
		notification.setContextPath(req.getRequestURI());
		notification.setStatus(HttpStatus.NOT_FOUND.name());
		return notification;
	}
	
	@ExceptionHandler(LogNotFoundExcpetion.class)
	public ExceptionNotification handleLogNotFoundExcpetion(HttpServletRequest req,LogNotFoundExcpetion ex) {
		final ExceptionNotification notification = new ExceptionNotification();
		notification.setErrorCode("125");
		notification.setDescription(ex.getMessage());
		notification.setContextPath(req.getRequestURI());
		notification.setStatus(HttpStatus.NOT_FOUND.name());
		return notification;
	}
	
}
