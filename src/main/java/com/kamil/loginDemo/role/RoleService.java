package com.kamil.loginDemo.role;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepo;
	
	@Transactional
	public Role insertRole(String role){
		return roleRepo.save(new Role(role));
	}
	
}
