package com.kamil.loginDemo.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecureConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		   http
           .authorizeRequests()
               .antMatchers("/", "/register").permitAll()
               .antMatchers("/admin").hasRole("ADMIN")
               .anyRequest().authenticated()
               .and()
           .formLogin()
               .loginPage("/login")
               .permitAll()
               .successForwardUrl("/")
               .and()
               .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
               .permitAll();


	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth
        .inMemoryAuthentication()
        .withUser("asd").password("{noop}asd").roles("USER")
.and()
        .withUser("aaa").password("{noop}asd").roles("ADMIN");
	}

}
