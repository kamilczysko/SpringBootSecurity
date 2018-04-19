package com.kamil.loginDemo.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@Configuration
@EnableWebSecurity
public class SecureConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserServiceImplementation userDetailsService;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		   http
		   
           .authorizeRequests()
               .antMatchers("/", "/register", "/h2").permitAll()
               .antMatchers("/admin").hasRole("ADMIN")
               .anyRequest().authenticated()
               .and()
               
           .formLogin()
               .loginPage("/login")
               .failureForwardUrl("/login-error")
               .permitAll()
               .successForwardUrl("/")
               .and()
               .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
               .permitAll();
		   
//		   http.csrf().disable();
		  


	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().and().userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		
//	     auth
//         .inMemoryAuthentication()
//         .withUser("admin").password("{noop}admin").roles("ADMIN")
//         .and().withUser("user").password("{noop}user").roles("USER");
	}
	
    @Bean
    public SpringSecurityDialect springSecurityDialect(){
        return new SpringSecurityDialect();
    }

}
