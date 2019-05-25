package com.t.service;

import java.util.List;

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
			public Result<List<Student>> getStudents() {
				return null;
			}
			
			@Override
			public Result<Student> getStudent(Long id) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}
	
}
