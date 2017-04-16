package com.meedesidy.controler;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meedesidy.entity.BaseEntity;
import com.meedesidy.entity.Menu;
import com.meedesidy.service.BaseService;
import com.meedesidy.service.IMenuService;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {
	@Resource
	private IMenuService menuService;

	@RequestMapping(value = "pageQuery")
	public @ResponseBody Object pageQuery(Menu entity) throws Exception {
		Object obj = super.pageQuery(entity);
		return obj;
	}

	@RequestMapping(value = "all")
	public @ResponseBody List<BaseEntity> all() {
		return getService().getAll();
	}
	
	@RequestMapping(value="get")
	public @ResponseBody Object get(Menu entity) {
		return getService().get(entity);
	}
	
	@RequestMapping(value="query")
	public @ResponseBody List<BaseEntity> query(Menu entity) {
		return super.query(entity);
	}
	
	@RequestMapping(value="save")
	public @ResponseBody Object save(Menu entity){
		if(entity.getResouce() == null){
			entity.setPid(null);
		}
		return super.save(entity);
	}
	
	@Override
	public BaseService getService() {
		return menuService;
	}
}