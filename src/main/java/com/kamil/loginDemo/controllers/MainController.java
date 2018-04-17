package com.kamil.loginDemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class MainController {
	
	@RequestMapping("/")
	private String index(){
//		model.addAttribute("name", name);
		return "index";
	}
	
	@RequestMapping(value = "/login")
	 public String login() {
		return "login";
	 }
	
	
	@RequestMapping("/register")
	private String register(){
		return "register";
	}
	
	@RequestMapping("/admin")
	private String admin(){
		return "adminPanel";
	}
	
	@RequestMapping("/usermanage")
	private String usermanage(){
		return "userManage";
	}
	
	
}
