package com.t.provider.controller;

import java.util.List;

import com.t.provider.config.RabbitConfig;
import com.t.provider.service.ClazzService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.t.api.Provider2Api;
import com.t.common.Result;
import com.t.common.ResultCode;
import com.t.model.Clazz;

@RestController
public class Provider2Controller implements Provider2Api {

	@Autowired
	private ClazzService clazzService;

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Override
	public Result<List<Clazz>> getClazzs() {
		amqpTemplate.convertAndSend(RabbitConfig.TEST_QUEUE, "hello world");
		return new Result<>(ResultCode.SUCCESS, clazzService.list());
	}

	@Override
	public Result<Clazz> getClazz(Long id) {
		return new Result<>(ResultCode.SUCCESS, clazzService.getById(id));
	}

	@Override
	public Result<Void> saveClazz(Clazz clazz) {
		return clazzService.saveOrUpdate(clazz) ? new Result<>(ResultCode.SUCCESS) : new Result<>(ResultCode.FAIL);
	}

	@Override
	public Result<Void> deleteClazz(Long id) {
		return clazzService.removeById(id) ? new Result<>(ResultCode.SUCCESS) : new Result<>(ResultCode.FAIL);
	}
}
