package com.t.aconsumer.controller;

import com.t.api.Provider1Api;
import com.t.api.Provider2Api;
import com.t.common.Result;
import com.t.common.ResultCode;
import com.t.model.Clazz;
import com.t.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
	
	@Autowired
	private Provider1Api provider1Service;
	
	@Autowired
	private Provider2Api provider2Service;
	
	@GetMapping("/test/{id}")
	public Result<Student> test(@PathVariable Long id) {
		return provider1Service.getStudent(id);
	}

	@GetMapping("/test")
	public Result<List<Student>> test() {
		provider2Service.getClazzs();
		return provider1Service.getStudents();
	}

	@GetMapping("/testlcn")
	public Result<Void> testlcn() {
		Student student = new Student() {{
			setAge(11);
			setName("xxxx111");
		}};

		Clazz clazz = new Clazz() {{
			setName("1");
			setStudentId(10l);
		}};
		long start = System.currentTimeMillis();
		Result studentResult = provider1Service.saveStudent(student);
		System.out.println(System.currentTimeMillis() - start);
		if (studentResult == null || !ResultCode.SUCCESS.equals(studentResult.getCode())) {
			return new Result<>(ResultCode.FAIL);
		}

		Result clazzResult = provider2Service.saveClazz(clazz);
		if (clazzResult == null || !ResultCode.SUCCESS.equals(clazzResult.getCode())) {
			return new Result<>(ResultCode.FAIL);
		}
		return new Result<>(ResultCode.SUCCESS);
	}
	
}
