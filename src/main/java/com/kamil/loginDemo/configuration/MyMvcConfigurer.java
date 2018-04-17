package com.kamil.loginDemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfigurer extends WebMvcConfigurerAdapter{


	    
	    @Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        registry.addViewController("/").setViewName("/");
	        registry.addViewController("/").setViewName("home");
	        registry.addViewController("/admin").setViewName("adminPanel");
	        registry.addViewController("/login").setViewName("login");
	    }
}
