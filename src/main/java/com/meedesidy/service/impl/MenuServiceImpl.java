package com.meedesidy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.meedesidy.dao.BaseDao;
import com.meedesidy.dao.MenuDao;
import com.meedesidy.entity.BaseEntity;
import com.meedesidy.service.IMenuService;

@Service("menuService")
public class MenuServiceImpl extends BaseServiceImpl implements IMenuService{

	@Resource
	private MenuDao menuDao;
	
	@Override
	public List<BaseEntity> pageQuery(BaseEntity entity) {
		// TODO Auto-generated method stub
		return getDao().pageQuery(entity);
	}

	@Override
	public BaseDao getDao() {
		// TODO Auto-generated method stub
		return menuDao;
	}
	
	
	

}
