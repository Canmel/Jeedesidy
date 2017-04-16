package com.meedesidy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meedesidy.dao.BaseDao;
import com.meedesidy.dao.UserDao;
import com.meedesidy.entity.BaseEntity;
import com.meedesidy.service.IUserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements IUserService{

	@Resource
	private UserDao userDao;
	
	@Override
	public List<BaseEntity> pageQuery(BaseEntity entity) {
		// TODO Auto-generated method stub
		return getDao().pageQuery(entity);
	}

	@Override
	public BaseDao getDao() {
		// TODO Auto-generated method stub
		return userDao;
	}

}
