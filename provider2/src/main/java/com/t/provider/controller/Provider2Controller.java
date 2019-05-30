package com.t.provider.controller;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.t.api.Provider2Api;
import com.t.common.Result;
import com.t.common.ResultCode;
import com.t.model.Clazz;
import com.t.provider.config.RabbitConfig;
import com.t.provider.service.ClazzService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Provider2Controller implements Provider2Api {

	@Autowired
	private ClazzService clazzService;

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Autowired
	private RedisTemplate redisTemplate;

	@Override
	public Result<List<Clazz>> getClazzs() {
		amqpTemplate.convertAndSend(RabbitConfig.TEST_QUEUE, "hello world");
		redisTemplate.opsForHash().put("test","1", "2");
		return new Result<>(ResultCode.SUCCESS, clazzService.list());
	}

	@Override
	public Result<Clazz> getClazz(Long id) {
		return new Result<>(ResultCode.SUCCESS, clazzService.getById(id));
	}

	@Override
	@Transactional
	@LcnTransaction(propagation = DTXPropagation.SUPPORTS)
	public Result<Void> saveClazz(Clazz clazz) {
		return clazzService.saveOrUpdate(clazz) ? new Result<>(ResultCode.SUCCESS) : new Result<>(ResultCode.FAIL);
	}

	@Override
	public Result<Void> deleteClazz(Long id) {
		return clazzService.removeById(id) ? new Result<>(ResultCode.SUCCESS) : new Result<>(ResultCode.FAIL);
	}
}
