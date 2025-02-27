package com.theta.platform.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.theta.platform.Entity.ResultResp;

@Controller
@RequestMapping(value={"/userLogin"})
public class UserLoginController {
	
	@RequestMapping("/login")
	@ResponseBody
	public ResultResp login(HttpServletRequest request,HttpServletResponse response,String userId){
		ResultResp resp = new ResultResp();
		resp.setCode(ResultResp.SUCCESS);
		resp.setData("index.jsp");
		return resp;
	}
}
