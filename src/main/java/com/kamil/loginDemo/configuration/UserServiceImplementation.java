package com.kamil.loginDemo.configuration;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kamil.loginDemo.user.User;
import com.kamil.loginDemo.user.UserService;

@Service
public class UserServiceImplementation implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.getUserByEmail(email);

		Set<GrantedAuthority> grantedAuthorities = new HashSet();

//		System.out.println("rola: "+user.role.toString()+" -- "+user.mail);
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+user.role.toString()));

		return new org.springframework.security.core.userdetails.User(user.mail, user.password,
				grantedAuthorities);
	}
}
