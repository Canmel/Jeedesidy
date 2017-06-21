package com.meedesidy.controler;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.ws.rs.GET;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meedesidy.entity.BaseEntity;
import com.meedesidy.entity.Role;
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
	public Object delete(@PathVariable int id, HttpServletResponse resp) {
		int[] ids = new int[1];
		ids[0] = id;
		try {
			super.del(ids);
			return super.get(new User((Integer) super.del(ids)));
		} catch (Exception e) {
			resp.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			return "删除失败";
		}
	}
	
	@RequestMapping(value = "save")
	public @ResponseBody Object saveObject(@Valid User entity, @RequestParam(value = "role_ids[]") ArrayList<Integer> role_ids, BindingResult result, HttpServletResponse resp){
		System.out.println("保存role_ids=>" + role_ids.toString());
		ArrayList<Role> roles = new ArrayList<Role>();
		for (Integer id : role_ids) {
			roles.add(new Role(id));
		}
		entity.setRoles(roles);
		if(result.hasErrors()){
			System.out.println(result.getAllErrors());
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
		return userService;
	}
}