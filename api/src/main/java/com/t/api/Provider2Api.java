package com.t.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.t.common.Result;
import com.t.model.Clazz;

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
