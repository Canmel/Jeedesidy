package com.meedesidy.controler;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meedesidy.entity.BaseEntity;
import com.meedesidy.entity.Menu;
import com.meedesidy.entity.User;
import com.meedesidy.entity.enumtype.BaseEnum;
import com.meedesidy.entity.enumtype.MenuType;
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
	
	@RequestMapping(value = "del")
	public Object del(int[] ids, HttpServletResponse resp) {
		try {
			return super.del(ids);
		} catch (Exception e) {
			resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return "删除失败";
		}
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public @ResponseBody Object delete(@PathVariable int id, HttpServletResponse resp) {
		int[] ids = new int[1];
		ids[0] = id;
		try {
			return super.del(ids);
		} catch (Exception e) {
			resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return "删除失败";
		}
	}
	
	@RequestMapping(value="save")
	public @ResponseBody Object save(Menu entity, HttpServletResponse resp, HttpServletRequest req){
		buildEntityFromReq(req, entity);
		if(entity.getResouce() == null){
			entity.setPid(null);
			return "参数错误";
		}
		try {
			return super.save(entity);
		} catch (Exception e) {
			System.err.println(e);
			resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return "保存失败";
		}
	}
	
	@Override
	public BaseService getService() {
		return menuService;
	}
	
	private Menu buildEntityFromReq(HttpServletRequest req, Menu entity) {
		entity.setMenuType((MenuType)BaseEnum.getEnumByInd(MenuType.class, Integer.parseInt(req.getParameter("menuType_id"))));
		return entity;
	}
}