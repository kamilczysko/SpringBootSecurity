package com.kamil.loginDemo.user;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamil.loginDemo.role.RoleService;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepo;
	
	@Autowired
	private RoleService roleService;
	
	@Transactional
	public User insertUser(User user){
		return userRepo.save(user);
	}
	
	public User getUserByEmail(String mail){
		return userRepo.findByMail(mail);
	}
	
	public List<User> getAllUsers(){
		return (List<User>) userRepo.findAll();
	}
	
	public User getUserById(long id){
		return userRepo.findById(id).get();
	}
	
	
	public void ban(long id){
		Optional<User> usr = userRepo.findById(id);
		User user = usr.get();
		user.banned = !user.banned;
		userRepo.save(user);
	}
		
	public User registerNewUser(User user){
		System.out.println("register new user");
		user.setRole(roleService.getRole("USER"));
		return userRepo.save(user);
	}
	
}
