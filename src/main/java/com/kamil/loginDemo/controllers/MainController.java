package com.kamil.loginDemo.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kamil.loginDemo.user.UserService;

@Controller
class MainController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	private String index(){
//		model.addAttribute("name", name);
		return "index";
	}
	
	@RequestMapping(value = "/login")
	 public String login() {
		return "login";
	 }

	@RequestMapping(value = "/login-error")
	 public String login(Model model) {
		model.addAttribute("loginError", true);
		return "login";
	 }
	
	@RequestMapping("/register")
	private String register(){
		return "register";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	private String admin(Model model, Principal principal){
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("principal", principal.getName());
		return "adminPanel";
	}
	
	@RequestMapping("/usermanage")
	private String usermanage(){
		return "userManage";
	}
	
	@RequestMapping(value="/ban", method=RequestMethod.POST)
	private String ban(@RequestParam("userid") Long id, Model model){
		userService.ban(id);
		model.addAttribute("users", userService.getAllUsers());
		return "adminPanel";
	}
	
	
}
