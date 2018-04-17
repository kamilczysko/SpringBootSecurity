package com.kamil.loginDemo.user;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepo;
	
	@Transactional
	public User insertUser(User user){
		return userRepo.save(user);
	}
	
	public User getUserByEmail(String mail){
		return userRepo.findByMail(mail);
	}
	
}
