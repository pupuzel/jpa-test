package com.jockjock.jpa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jockjock.jpa.service.TestRelationService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
public class TestRelationController {
	
	private TestRelationService testRelationService;
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map> exception(Exception e) {
		log.info("ExceptionHandler -------> ", e);
		
		Map result = new HashMap<String,Object>();
		result.put("result", "N");
		
		return new ResponseEntity<Map>(result, HttpStatus.OK);
	}
	
	
	/****************************************************************************************/
	
	@RequestMapping("/api/save")
	public ResponseEntity<Void> save(HttpServletRequest request) throws Exception{
		testRelationService.save();
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping("/api/read")
	public ResponseEntity<Void> read(HttpServletRequest request) throws Exception{
		testRelationService.read();
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
