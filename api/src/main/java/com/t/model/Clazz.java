package com.t.model;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

@TableName("class")
public class Clazz {

	@TableId(type = IdType.AUTO)
	private Long id;
	
	private Long studentId;
	
	private String name;

	@TableField(value = "create_time",fill = FieldFill.INSERT)
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
