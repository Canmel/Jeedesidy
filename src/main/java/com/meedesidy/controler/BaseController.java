package com.meedesidy.controler;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.meedesidy.service.BaseService;
import com.meedesidy.entity.BaseEntity;
import com.meedesidy.entity.PageQuery;

public abstract class BaseController {
	
	public final static String basepage = "";
	
	@RequestMapping(value = "index")
	public Object index() throws Exception {
		return getCurPath() + "index";
	}

	public List<BaseEntity> query(BaseEntity entity){
		return getService().query(entity);
	}
	
	public PageQuery pageQuery(BaseEntity entity) throws Exception {
		PageQuery pageQuery =new PageQuery();
		pageQuery.setResult(getService().pageQuery(entity));
		pageQuery.setTotal(entity.ptotal);
		return pageQuery;
	}
	
	public abstract BaseService getService();
	
	public String getCurPath() {
		return getPath(getClass());
	}
	
	public Object del(int[] ids) throws Exception {
		return getService().del(ids);
	}
	
	public Object get(BaseEntity entity) {
		return getService().get(entity);
	}
	
	public static String getPath(Class clazz) {
		return basepage + "/"
				+ clazz.getSimpleName().replace("Controller", "/").toLowerCase();
	}

	public List<BaseEntity> getAll() {
		// TODO Auto-generated method stub
		return getService().getAll();
	}

	public Object save(BaseEntity entity) throws Exception{
		// TODO Auto-generated method stub
		return getService().save(entity);
	}
	
}
