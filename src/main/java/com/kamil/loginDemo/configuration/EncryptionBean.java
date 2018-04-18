package com.kamil.loginDemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
public class EncryptionBean {

	
	@Bean
	public BCryptPasswordEncoder passEncoder(){
		return new BCryptPasswordEncoder();
	}
}
