package com.meedesidy.service.impl;

import com.meedesidy.dao.BaseDao;
import com.meedesidy.dao.RoleDao;
import com.meedesidy.entity.BaseEntity;
import com.meedesidy.service.IMenuService;
import com.meedesidy.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl implements IRoleService{

	@Resource
	private RoleDao roleDao;
	
	@Override
	public List<BaseEntity> pageQuery(BaseEntity entity) {
		return getDao().pageQuery(entity);
	}

	@Override
	public BaseDao getDao() {
		return roleDao;
	}
	
	
	

}
