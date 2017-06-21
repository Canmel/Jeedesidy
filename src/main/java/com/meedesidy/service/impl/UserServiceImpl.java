package com.meedesidy.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.meedesidy.dao.UserDao;
import com.meedesidy.entity.BaseEntity;
import com.meedesidy.entity.User;
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
	
	@Transactional
	@Override
	public Object save(BaseEntity entity) throws Exception {
		if(null == entity.id){
			getDao().add(entity);
		}else {
			getDao().update(entity);
		}
		getDao().delRole((User)entity);
		getDao().saveRole(((User)entity).getRoles(), entity.getId());
		return getDao().get(entity);
	}

	@Override
	public Object del(int[] ids) {
		for (int item : ids) {
			User user = new User(item);
			getDao().delRole(user);
		}
		return super.del(ids);
	}
	
	@Override
	public UserDao getDao() {
		// TODO Auto-generated method stub
		return userDao;
	}
}
