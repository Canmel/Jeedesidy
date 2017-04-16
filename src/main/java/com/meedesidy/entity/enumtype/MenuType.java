package com.meedesidy.entity.enumtype;

public enum MenuType implements CodeBaseEnum{
	TOPMENU(0, "一级菜单"),
	SUBMENU(1, "二级菜单");
	
	private int index;
	
	private String name;
	
	private MenuType(int index, String name) {
		this.index = index;
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public int code() {
        return this.index;
    }
}
