package com.t.api;

import com.t.common.Result;
import com.t.model.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface Provider1Api {
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public Result<List<Student>> getStudents();
	
	@RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
	public Result<Student> getStudent(@PathVariable Long id);

	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public Result<Void> saveStudent(@RequestBody Student student);

	@RequestMapping(value = "/student", method = RequestMethod.DELETE)
	public Result<Void> deleteStudent(@PathVariable Long id);
}
