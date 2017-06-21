package com.meedesidy.service;

import java.util.List;

import com.meedesidy.entity.BaseEntity;

public interface BaseService {

	public List<BaseEntity> pageQuery(BaseEntity entity);

	public List<BaseEntity> getAll();

	public Object get(BaseEntity entity);

	public Object save(BaseEntity entity) throws Exception;

	public List<BaseEntity> query(BaseEntity entity);
	
	public Object del(int[] ids) throws Exception;

}
