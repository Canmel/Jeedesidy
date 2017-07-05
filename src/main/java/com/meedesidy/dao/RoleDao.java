package com.meedesidy.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.meedesidy.entity.Menu;
import com.meedesidy.entity.Role;

public interface RoleDao extends BaseDao {
	public Integer saveMenus(@Param("menus") ArrayList<Menu> menus, @Param("role_id") Integer role_id);
	public Integer delMenus(Role role);
}
