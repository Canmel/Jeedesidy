package com.meedesidy.controler;

import com.meedesidy.entity.BaseEntity;
import com.meedesidy.entity.Role;
import com.meedesidy.service.BaseService;
import com.meedesidy.service.IRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

import java.lang.reflect.Proxy;
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
	public @ResponseBody Object saveObject(@Valid Role entity, BindingResult result){
		if(result.hasErrors()){
			return "error";
		}
		return super.save(entity);
	}

	@Override
	public BaseService getService() {
		return roleService;
	}
}