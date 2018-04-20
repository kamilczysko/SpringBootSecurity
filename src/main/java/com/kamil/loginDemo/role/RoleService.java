package com.kamil.loginDemo.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;
	
	public Role insertRole(String role){
		return roleRepo.save(new Role(role));
	}
	
	public List<Role> getAllRoles(){
		return (List<Role>) roleRepo.findAll();
	}
	
	public Role getRole(String role){
		return roleRepo.findByRole(role);
	}
	
}
