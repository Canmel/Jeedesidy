package com.meedesidy.service.impl;

import com.meedesidy.dao.BaseDao;
import com.meedesidy.dao.RoleDao;
import com.meedesidy.dao.UserDao;
import com.meedesidy.entity.BaseEntity;
import com.meedesidy.entity.Role;
import com.meedesidy.entity.User;
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
	public Object save(BaseEntity entity) throws Exception {
		super.save(entity);
//		更新角色菜单
//		1. 删除所有
		getDao().delMenus((Role)entity);
//		2. 添加所有
		getDao().saveMenus(((Role)entity).getMenus(), entity.getId());
		return getDao().get(entity);
	}

	@Override
	public RoleDao getDao() {
		return roleDao;
	}
	
	
	

}
