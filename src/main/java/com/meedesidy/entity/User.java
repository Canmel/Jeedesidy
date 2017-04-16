package com.meedesidy.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class User extends BaseEntity{
	public String password;
	
	public String remark;
	
	@NotNull(message = "{user.age.null}")  
	public Integer age;
	
	@NotNull(message = "{user.phone.null}")
	@Length(min = 11, max = 11, message = "{user.name.length.illegal}")
	public String phone;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}	