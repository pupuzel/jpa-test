package com.jockjock.jpa.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jockjock.jpa.service.TestService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
public class TestController {
	
	private TestService testService;
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map> exception(Exception e) {
		log.info("ExceptionHandler -------> ", e);
		Map result = new HashMap<String,Object>();
		result.put("result", "N");
		
		return new ResponseEntity<Map>(result, HttpStatus.OK);
	}
	
	@RequestMapping("/api/save")
	public ResponseEntity<Map> save(HttpServletRequest request) throws Exception{
		return new ResponseEntity<Map>(testService.save(), HttpStatus.OK);
	}
	
	@RequestMapping("/api/read")
	public ResponseEntity<Map> read(HttpServletRequest request) throws Exception{
		return new ResponseEntity<Map>(testService.read(), HttpStatus.OK);
	}
	
}
