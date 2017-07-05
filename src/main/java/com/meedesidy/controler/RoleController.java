package com.meedesidy.controler;

import com.meedesidy.entity.BaseEntity;
import com.meedesidy.entity.Menu;
import com.meedesidy.entity.Role;
import com.meedesidy.service.BaseService;
import com.meedesidy.service.IRoleService;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
	@Resource
	private IRoleService roleService;

	@RequestMapping(value = "pageQuery")
	public @ResponseBody Object pageQuery(Role entity) throws Exception {
		return super.pageQuery(entity);
	}

	@RequestMapping(value = "all")
	public @ResponseBody List<BaseEntity> all() {
		return super.getAll();
	}
	
	@RequestMapping(value = "get")
	public @ResponseBody Object get(Role entity){
		return getService().get(entity);
	}
	
	@RequestMapping(value = "save")
	public @ResponseBody Object saveObject(@Valid Role entity, BindingResult result, @RequestParam(value = "menu_ids[]") ArrayList<Integer> menu_ids, HttpServletResponse resp){
		ArrayList<Menu> menus = new ArrayList<Menu>();
		for (Integer id : menu_ids) {
			menus.add(new Menu(id));
		}
		entity.setMenus(menus);
		if(result.hasErrors()){
			return result.getAllErrors().toString();
		}
		try {
			return super.save(entity);
		} catch (Exception e) {
			resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return "保存出错";
		}
	}

	@Override
	public BaseService getService() {
		return roleService;
	}
}