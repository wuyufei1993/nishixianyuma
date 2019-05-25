package com.t.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.t.common.Result;
import com.t.model.Student;

public interface Provider1Api {
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public Result<List<Student>> getStudents();
	
	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public Result<Student> getStudent(@PathVariable Long id);
}
