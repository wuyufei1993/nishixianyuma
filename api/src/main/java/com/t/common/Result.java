package com.t.common;

public class Result <T> {
	
	private ResultCode code;
	
	private String msg;
	
	private T t;

	public static Result<?> SUCCESS = new Result<>(ResultCode.SUCCESS);
	
	public static Result<?> FAIL = new Result<>(ResultCode.FAIL);
	
	public Result() {
		super();
	}

	public Result(ResultCode code) {
		super();
		this.code = code;
	}

	public Result(ResultCode code, T t) {
		super();
		this.code = code;
		this.t = t;
	}

	public Result(ResultCode code, String msg, T t) {
		super();
		this.code = code;
		this.msg = msg;
		this.t = t;
	}

	public ResultCode getCode() {
		return code;
	}

	public void setCode(ResultCode code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
	
}
