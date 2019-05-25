package com.t.aconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t.common.Result;
import com.t.model.Student;
import com.t.service.Provider1Service;
import com.t.service.Provider2Service;

@RestController
public class TestController {
	
	@Autowired
	private Provider1Service provider1Service;
	
	@Autowired
	private Provider2Service provider2Service;
	
	@GetMapping("/test")
	public Result<Student> test() {
		return provider1Service.getStudent((long) 1);
	}
	
}
