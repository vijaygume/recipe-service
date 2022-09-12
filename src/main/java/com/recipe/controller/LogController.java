package com.recipe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.model.Log;
import com.recipe.model.LogLevel;
import com.recipe.service.LogService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/log")
@Slf4j
public class LogController {

	@Autowired
	private LogService logService;

	@GetMapping("/content")
	public List<String> getLogContent(){

		return logService.readLogFile();
	}

	@GetMapping("/content/{level}")
	public List<Log> getLogContent(@PathVariable LogLevel level){
		log.info("level {}",level);

		return logService.splitLogByType(level);
	}

	@PostMapping("/content")
	public List<Log> getLogContent(@RequestBody List<String> levels){
		log.info("level {}",levels);
		List<Log> logs = new ArrayList<>();
		
		levels.forEach(l-> logs.addAll(logService.splitLogByType(LogLevel.valueOf(l))));

		return logs;
	}

}
