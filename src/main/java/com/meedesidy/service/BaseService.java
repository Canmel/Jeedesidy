package com.meedesidy.service;

import java.util.List;

import com.meedesidy.entity.BaseEntity;
import com.meedesidy.entity.Menu;
import com.meedesidy.entity.User;

public interface BaseService {

	public List<BaseEntity> pageQuery(BaseEntity entity);

	public List<BaseEntity> getAll();

	public Object get(BaseEntity entity);

	public Object save(BaseEntity entity);

	public List<BaseEntity> query(BaseEntity entity);

}
