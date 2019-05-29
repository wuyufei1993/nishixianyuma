package com.t.aconsumer.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.t.common.Result;
import com.t.common.ResultCode;
import com.t.model.Clazz;
import com.t.model.Student;
import com.t.service.Provider1Service;
import com.t.service.Provider2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
		provider2Service.getClazzs();
		return provider1Service.getStudents();
	}

	@LcnTransaction
	@GetMapping("/testlcn")
	public Result<Void> testlcn() {
		Student student = new Student() {{
			setAge(11);
			setName("xxxx");
		}};

		Clazz clazz = new Clazz() {{
			setName("1");
			setStudentId(10l);
		}};
		provider1Service.saveStudent(student);
		provider2Service.saveClazz(clazz);
		return new Result<>(ResultCode.SUCCESS);
	}
	
}
