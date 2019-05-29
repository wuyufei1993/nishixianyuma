package com.t.service;

import java.util.List;

import com.t.common.ResultCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import com.t.api.Provider2Api;
import com.t.common.Result;
import com.t.model.Clazz;

import feign.hystrix.FallbackFactory;

@FeignClient(value = "provider2", fallbackFactory = Provider2FallbaclFactory.class)
public interface Provider2Service extends Provider2Api {

}

@Component
class Provider2FallbaclFactory implements FallbackFactory<Provider2Service> {

	@Override
	public Provider2Service create(Throwable cause) {
		return new Provider2Service() {
			@Override
			public Result<Void> saveClazz(Clazz clazz) {
				return new Result<>(ResultCode.ERROR);
			}

			@Override
			public Result<Void> deleteClazz(Long id) {
				return new Result<>(ResultCode.ERROR);
			}

			@Override
			public Result<List<Clazz>> getClazzs() {
				return new Result<>(ResultCode.ERROR);
			}
			
			@Override
			public Result<Clazz> getClazz(Long id) {
				return new Result<>(ResultCode.ERROR);
			}
		};
	}

	
}
