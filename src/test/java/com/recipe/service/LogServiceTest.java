package com.recipe.service;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.recipe.model.Log;
import com.recipe.model.LogLevel;

public class LogServiceTest{
	
	@Test
	public void testReadFileLog() {

		LogService service = new LogServiceImpl();
		List<String> lines = service.readLogFile();
		
		assertFalse(lines.isEmpty());
	}
	
	@Test
	public void testSplitLogByType() {
		LogService service = new LogServiceImpl();
		
		List<Log> logs = service.splitLogByType(LogLevel.INFO);
		
		assertFalse(logs.isEmpty());
		
		
	}
	


}



