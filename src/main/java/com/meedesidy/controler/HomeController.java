package com.meedesidy.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meedesidy.service.BaseService;
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {

	@Override
	public BaseService getService() {
		// TODO Auto-generated method stub
		return null;
	}
}