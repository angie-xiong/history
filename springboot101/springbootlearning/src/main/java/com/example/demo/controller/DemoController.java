package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * How to use spring-boot controller.
 * 
 * @author anqi.xiong
 *
 */
@RestController // 1. RestController is used as Controller in spring MVC.
@RequestMapping("/hello")
public class DemoController {

	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello world! ";
	}

}
