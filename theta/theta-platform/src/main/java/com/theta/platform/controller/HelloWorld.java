package com.theta.platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorld {

	@RequestMapping(value="/hello", method = {RequestMethod.POST, RequestMethod.GET,RequestMethod.OPTIONS})
	@ResponseBody
	public ModelAndView hello(){
		ModelAndView mv = new ModelAndView("login/login");
		//return "hello, world! It comes from spring-mvc!";	
		return mv;
	}
}
