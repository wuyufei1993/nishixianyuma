package com.t.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.t.common.Result;
import com.t.model.Clazz;

public interface Provider2Api {
	
	@RequestMapping(value = "/clazz", method = RequestMethod.GET)
	public Result<List<Clazz>> getClazzs();
	
	@RequestMapping(value = "/clazz/{id}", method = RequestMethod.GET)
	public Result<Clazz> getClazz(@PathVariable Long id);
}
