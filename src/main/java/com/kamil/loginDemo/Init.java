package com.kamil.loginDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.kamil.loginDemo.role.Role;
import com.kamil.loginDemo.role.RoleService;
import com.kamil.loginDemo.user.User;
import com.kamil.loginDemo.user.UserService;

@Component
public class Init implements CommandLineRunner{

	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		Role admin = roleService.insertRole("ADMIN");
		Role user = roleService.insertRole("USER");
		
		userService.insertUser(new User("kamil", "walczak", "dupa@dupa.pl", admin, passEncoder.encode("asd")));
		userService.insertUser(new User("marek", "warek", "pupka@dupa.pl", admin, passEncoder.encode("asd")));
		userService.insertUser(new User("jelcz", "sutek", "asd@dupa.pl", user, passEncoder.encode("asd")));
		userService.insertUser(new User("makaron", "erwer", "asdxxa@adupa.pl", user, passEncoder.encode("asd")));
		
		
	}
	
	
	
	
	
}
