package com.t.common;

public class Result <T> {
	
	private ResultCode code;
	
	private String msg;
	
	private T data;

	public static Result<?> SUCCESS = new Result<>(ResultCode.SUCCESS);
	
	public static Result<?> FAIL = new Result<>(ResultCode.FAIL);
	
	public Result() {
		super();
	}

	public Result(ResultCode code) {
		super();
		this.code = code;
	}

	public Result(ResultCode code, T data) {
		super();
		this.code = code;
		this.data = data;
	}

	public Result(ResultCode code, String msg, T data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
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

	public T getData() {
		return data;
	}

	public void setData(T t) {
		this.data = data;
	}
	
}
