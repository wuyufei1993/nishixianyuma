package com.t.service;

import java.util.List;

import com.t.common.ResultCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import com.t.api.Provider1Api;
import com.t.common.Result;
import com.t.model.Student;

import feign.hystrix.FallbackFactory;

@FeignClient(value = "provider1", fallbackFactory = Provider1FallbackFactory.class)
public interface Provider1Service extends Provider1Api {

}

@Component
class Provider1FallbackFactory implements FallbackFactory<Provider1Service> {

	@Override
	public Provider1Service create(Throwable cause) {
		return new Provider1Service() {
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
