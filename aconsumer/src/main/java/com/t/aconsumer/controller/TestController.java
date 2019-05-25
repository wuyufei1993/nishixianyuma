package com.t.aconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.t.common.Result;
import com.t.model.Student;
import com.t.service.Provider1Service;
import com.t.service.Provider2Service;

import java.util.List;

@RestController
public class TestController {
	
	@Autowired
	private Provider1Service provider1Service;
	
	@Autowired
	private Provider2Service provider2Service;
	
	@GetMapping("/test/{id}")
	public Result<Student> test(@PathVariable Long id) {
		return provider1Service.getStudent(id);
	}

	@GetMapping("/test")
	public Result<List<Student>> test() {
		return provider1Service.getStudents();
	}
	
}
