package com.t.provider.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.t.api.Provider1Api;
import com.t.common.Result;
import com.t.common.ResultCode;
import com.t.model.Student;

@RestController
public class Provider1Controller implements Provider1Api {

	@Override
	public Result<List<Student>> getStudents() {
		return new Result<List<Student>>(ResultCode.SUCCESS, new ArrayList<Student>() {{add(new Student());}});
	}

	@Override
	public Result<Student> getStudent(@PathVariable Long id) {
		return new Result<Student>(ResultCode.SUCCESS, new Student() {{setId(id);}});
	}

}
