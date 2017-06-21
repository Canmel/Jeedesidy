package com.meedesidy.service;

import com.meedesidy.entity.BaseEntity;

public interface IUserService extends BaseService{
	@Override
	Object save(BaseEntity entity) throws Exception;
	
	@Override
	Object del(int[] ids) throws Exception;
}
