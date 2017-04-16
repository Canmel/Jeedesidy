package com.meedesidy.service.impl;

import java.util.List;

import com.meedesidy.dao.BaseDao;
import com.meedesidy.entity.BaseEntity;
import com.meedesidy.entity.Menu;
import com.meedesidy.entity.User;
import com.meedesidy.service.BaseService;

public abstract class BaseServiceImpl implements BaseService{
	
	@Override
	public List<BaseEntity> pageQuery(BaseEntity entity) {
		// TODO Auto-generated method stub
		return getDao().pageQuery(entity);
	}
	
	@Override
	public List<BaseEntity> getAll() {
		// TODO Auto-generated method stub
		return getDao().getAll();
	}
	
	@Override
	public Object get(BaseEntity entity) {
		// TODO Auto-generated method stub
		return getDao().get(entity);
	}
	
	@Override
	public Object save(BaseEntity entity) {
		// TODO Auto-generated method stub
		if(null == entity.id){
			getDao().add(entity);
		}else {
			getDao().update(entity);
		}
		return getDao().get(entity);
	}
	
	@Override
	public List<BaseEntity> query(BaseEntity entity) {
		// TODO Auto-generated method stub
		return getDao().query(entity);
	}
	
	public abstract BaseDao getDao();
}
