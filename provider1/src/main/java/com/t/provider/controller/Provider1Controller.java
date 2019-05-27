package com.t.provider.controller;

import com.t.api.Provider1Api;
import com.t.common.Result;
import com.t.common.ResultCode;
import com.t.model.Student;
import com.t.provider.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Provider1Controller implements Provider1Api {

	@Autowired
	private StudentService studentService;

	@Override
	public Result<List<Student>> getStudents() {
		return new Result<>(ResultCode.SUCCESS, studentService.list());
	}

	@Override
	public Result<Student> getStudent(@PathVariable Long id) {
		return new Result<>(ResultCode.SUCCESS, studentService.getById(id));
	}

}
