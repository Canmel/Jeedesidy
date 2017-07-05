package com.meedesidy.entity;

import java.util.ArrayList;

public class Role extends BaseEntity{
    private ArrayList<Menu> menus;

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
    }
    
    public Role(Integer id) {
		this.id = id;
	}
    
    public Role() {
	}
}
