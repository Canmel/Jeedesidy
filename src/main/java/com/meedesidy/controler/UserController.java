package com.meedesidy.controler;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.ws.rs.GET;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meedesidy.entity.BaseEntity;
import com.meedesidy.entity.User;
import com.meedesidy.service.BaseService;
import com.meedesidy.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource
	private IUserService userService;

	@RequestMapping(value = "pageQuery")
	public @ResponseBody Object pageQuery(User entity) throws Exception {
		return super.pageQuery(entity);
	}

	@RequestMapping(value = "all")
	public @ResponseBody List<BaseEntity> all() {
		return super.getAll();
	}
	
	@RequestMapping(value = "get")
	public @ResponseBody Object get(User entity){
		return getService().get(entity);
	}
	
	@RequestMapping(value = "save")
	public @ResponseBody Object saveObject(@Valid User entity, BindingResult result){
		if(result.hasErrors()){
			return "error";
		}
		return super.save(entity);
	}

	@Override
	public BaseService getService() {
		return userService;
	}
}