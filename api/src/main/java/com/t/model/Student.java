package com.t.model;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

public class Student {

	@TableId(type = IdType.AUTO)
	private Long id;
	
	private String name;
	
	private Integer age;

	@TableField(value = "create_time",fill = FieldFill.INSERT, update = "now()")
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
