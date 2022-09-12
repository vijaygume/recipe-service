package com.recipe.service;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.recipe.exception.LogNotFoundExcpetion;
import com.recipe.model.Log;
import com.recipe.model.LogLevel;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LogServiceImpl implements LogService{

	@Override
	public List<String> readLogFile() {
		List<String> lines= new ArrayList<String>();
		try {
			lines = Files.readAllLines(new File("src/main/resources/logFile-2018-09-10.log").toPath());
		} catch (IOException e) {
			throw new LogNotFoundExcpetion("log file not found");
		}
		return lines;
	}

	@Override
	public List<Log> splitLogByType(LogLevel level){

		List<String> lines = readLogFile().stream().filter(l->l.contains(level.name())).collect(Collectors.toList());

		List<Log> logs = new ArrayList<Log>();

		lines.stream().forEach(l->{

			Log lo = splitLogByType(l,level);

			logs.add(lo);

		});		

		List<Log> processed = logs.stream().collect(
				groupingBy(
						Log::getMessage,
						summingInt(Log::getOccurrenceCount)))
				.entrySet().stream()
				.map(m->new Log(level,m.getKey(),m.getValue()))
				.sorted(Comparator.comparing(Log::getOccurrenceCount).reversed())
				.collect(Collectors.toList());

		return processed;

	}

	@Override
	public Log splitLogByType(String line,LogLevel level) {

		String[] splited =  line.split(level.name());
		List<String> str = Arrays.asList(splited);
		log.info("splited {}", str);

		return new Log(level,splited[1],1);
	}


}



