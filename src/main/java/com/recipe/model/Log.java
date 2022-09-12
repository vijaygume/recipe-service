package com.recipe.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {

	private LogLevel level;
	private String message;
	private int occurrenceCount;
	

}
