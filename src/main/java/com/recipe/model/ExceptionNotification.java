package com.recipe.model;

import lombok.Data;

@Data
public class ExceptionNotification {
	
	private String errorCode;
	
	private String description;
	
	private String contextPath;
	
	private String status;
}
