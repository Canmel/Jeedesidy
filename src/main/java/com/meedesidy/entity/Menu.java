package com.meedesidy.entity;

import com.meedesidy.entity.enumtype.MenuType;

import java.util.List;

public class Menu extends BaseEntity{
	
	public String resouce;
	
	public Integer pid;
	
	public MenuType type;

	public List<Role> role;

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public MenuType getType() {
		return type;
	}

	public void setType(MenuType type) {
		this.type = type;
	}

	public String getResouce() {
		return resouce;
	}

	public void setResouce(String resouce) {
		this.resouce = resouce;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
}	
