package com.meedesidy.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.meedesidy.entity.Role;
import com.meedesidy.entity.User;

public interface UserDao extends BaseDao {
	
	public Integer saveRole(@Param("roles") ArrayList<Role> roles, @Param("user_id") Integer user_id);
	
	public Integer delRole(User user);
}
