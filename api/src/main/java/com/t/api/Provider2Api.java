package com.t.api;

import com.t.common.Result;
import com.t.common.ResultCode;
import com.t.model.Clazz;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "provider2", fallbackFactory = Provider2FallbacKFactory.class)
public interface Provider2Api {
	
	@RequestMapping(value = "/clazz", method = RequestMethod.GET)
	public Result<List<Clazz>> getClazzs();
	
	@RequestMapping(value = "/clazz/{id}", method = RequestMethod.GET)
	public Result<Clazz> getClazz(@PathVariable Long id);

	@RequestMapping(value = "/clazz", method = RequestMethod.POST)
	public Result<Void> saveClazz(@RequestBody Clazz clazz);

	@RequestMapping(value = "/clazz", method = RequestMethod.DELETE)
	public Result<Void> deleteClazz(@PathVariable Long id);
}

@Component
class Provider2FallbacKFactory implements FallbackFactory<Provider2Api> {

	@Override
	public Provider2Api create(Throwable cause) {
		return new Provider2Api() {
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