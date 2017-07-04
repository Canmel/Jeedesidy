package com.meedesidy.entity.enumtype;

public class MenuType extends BaseEnum{
	public MenuType() {
		// TODO Auto-generated constructor stub
	}
	
	public MenuType(int id, String code, String name ){
		 super(id, code, name);
	}
	
	public static MenuType TOPMENU = new MenuType(1, "TOPMENU", "一级菜单");
    public static MenuType SUBMENU = new MenuType(2, "SUBMENU", "二级菜单");
}
