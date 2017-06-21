package com.meedesidy.dao;

import java.util.List;

import com.meedesidy.entity.BaseEntity;

public interface BaseDao {

	public List<BaseEntity> pageQuery(BaseEntity entity);

	public List<BaseEntity> getAll();

	public Object get(BaseEntity entity);

	public int add(BaseEntity entity);

	public int update(BaseEntity entity);

	public List<BaseEntity> query(BaseEntity entity);
	
	public int del(int[] ids);
}
