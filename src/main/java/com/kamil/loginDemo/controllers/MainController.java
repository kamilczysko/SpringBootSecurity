package com.kamil.loginDemo.controllers;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kamil.loginDemo.blog.Post;
import com.kamil.loginDemo.blog.PostService;
import com.kamil.loginDemo.role.RoleService;
import com.kamil.loginDemo.user.User;
import com.kamil.loginDemo.user.UserService;

@Controller
class MainController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping("/")
	private String index(Model model){
		model.addAttribute("userPosts", postService.getAllPosts());
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
	
	@RequestMapping(value="/registerform")
	private String register(Model model){
		model.addAttribute("user", new User());
		
//		model.addAttribute("role", roleService.getRole("USER"));
		return "register";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	private String admin(Model model, Principal principal){
		model.addAttribute("users", userService.getAllUsers());
		model.addAttribute("principal", principal.getName());
		model.addAttribute("roles", roleService.getAllRoles());
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
	
//	@Autowired
//	private BCryptPasswordEncoder passEncoder;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUser(@ModelAttribute User user){
		userService.registerNewUser(user);
		return "redirect:/index";
	}
	
	@Autowired PostService postService;
	
	@RequestMapping(value="/myblog")
	public String myBlog(Model model, Principal principal){
		User user = userService.getUserById(Integer.parseInt(principal.getName().split("#")[0]));
		model.addAttribute("userPosts", postService.getUsersPosts(user));
		model.addAttribute("post", new Post(user));
		model.addAttribute("user", user);
		return "myblog";
	}
	
	@RequestMapping(value="/myblog", method=RequestMethod.POST)
	public String saveMyPost(Model model, Principal principal, @ModelAttribute Post post){
		User user = userService.getUserById(Integer.parseInt(principal.getName().split("#")[0]));
		System.out.println(postService.getUsersPosts(user));
		System.out.println("POSTTTT: "+post.getContent()+" -- "+post.getTitle()+" = "+post.getAuthor().getFirstName()+" -- "+post.created);
		post.setCreated(new Date());
		postService.savePost(post);
		model.addAttribute("userPosts", postService.getUsersPosts(user));
		return "redirect:/myblog";
	}
	
	@RequestMapping(value="/updateuser", method=RequestMethod.POST)
	public String updateUser(@ModelAttribute User user){
		userService.registerNewUser(user);
		return "profile";
	}
	
	
	
	
	
}
