package com.ltkj.app.account.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("account/index")
public class IndexController {
		
	@RequestMapping("/show")
	public String show( HttpSession session) throws Exception{
		return "index";
	}

}
