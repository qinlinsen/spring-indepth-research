package com.timo.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Dog {
	private Integer age;
	private String name;
	@JSONField(format = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	@JSONField(serialize = false)
	private String remarks;

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
