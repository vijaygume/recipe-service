package com.recipe.service;

import java.util.List;

import com.recipe.model.Log;
import com.recipe.model.LogLevel;

public interface LogService {
	
	public List<String> readLogFile();
	public List<Log> splitLogByType(LogLevel level);
	public Log splitLogByType(String line,LogLevel level);
}
