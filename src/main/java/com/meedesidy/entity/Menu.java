package com.meedesidy.entity;

import com.meedesidy.entity.enumtype.MenuType;
import com.meedesidy.entity.enumtype.Status;

import java.util.List;

public class Menu extends BaseEntity{
	
	public String resouce;
	
	public Integer pid;
	
	public MenuType menuType;

	public List<Role> role;

	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public MenuType getMenuType() {
		return menuType;
	}

	public void setMenuType(MenuType menuType) {
		this.menuType = menuType;
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
	
	public Menu(int id){
		this.id = id;
	}
	
	public Menu() {
	}
}	
