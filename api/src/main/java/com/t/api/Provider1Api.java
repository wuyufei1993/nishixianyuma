package com.t.api;

import com.t.common.Result;
import com.t.common.ResultCode;
import com.t.model.Student;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "provider1", fallbackFactory = Provider1FallbackFactory.class)
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

@Component
class Provider1FallbackFactory implements FallbackFactory<Provider1Api> {

	@Override
	public Provider1Api create(Throwable cause) {
		return new Provider1Api() {
			@Override
			public Result<Void> saveStudent(Student student) {
				return new Result<>(ResultCode.ERROR);
			}

			@Override
			public Result<Void> deleteStudent(Long id) {
				return new Result<>(ResultCode.ERROR);
			}

			@Override
			public Result<List<Student>> getStudents() {
				return new Result<>(ResultCode.ERROR);
			}

			@Override
			public Result<Student> getStudent(Long id) {
				return new Result<>(ResultCode.ERROR);
			}
		};
	}

}