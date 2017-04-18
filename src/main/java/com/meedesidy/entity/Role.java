package com.meedesidy.entity;

import java.util.List;

public class Role extends BaseEntity{
    private List<Menu> menu;

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }
}
