package com.kamil.loginDemo.user;

import java.util.List;
import java.util.Optional;

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
	
	public List<User> getAllUsers(){
		return (List<User>) userRepo.findAll();
	}
	
	
	public void ban(long id){
		Optional<User> usr = userRepo.findById(id);
		User user = usr.get();
		user.banned = !user.banned;
		userRepo.save(user);
	}
	
}
