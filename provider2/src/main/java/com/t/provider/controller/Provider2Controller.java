package com.t.provider.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.t.api.Provider2Api;
import com.t.common.Result;
import com.t.common.ResultCode;
import com.t.model.Clazz;

@RestController
public class Provider2Controller implements Provider2Api {

	@Override
	public Result<List<Clazz>> getClazzs() {
		return new Result<List<Clazz>>(ResultCode.FAIL);
	}

	@Override
	public Result<Clazz> getClazz(Long id) {
		return new Result<Clazz>(ResultCode.FAIL);
	}

}
