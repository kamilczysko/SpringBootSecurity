package com.kamil.loginDemo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kamil.loginDemo.role.Role;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

	public User(){}

	public User(String firstName, String secondName, String mail, Role role, String password){
		this.firstName = firstName;
		this.secondName = secondName;
		this.mail= mail;
		this.role = role;
		this.password = password;
	}
	
	public User(String firstName, String secondName, String mail, Role role, String password, boolean banned){
		this.firstName = firstName;
		this.secondName = secondName;
		this.mail= mail;
		this.role = role;
		this.password = password;
		this.banned = banned;
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;

	@NotNull
	private String firstName;

	@NotNull
	private String secondName;
	
	@Email
	@NotNull
	@Column(unique=true)
	public String mail;
	
	@NotNull
	public String password;
	
	@NotNull
	public boolean banned = false;
	
	@OneToOne
	public Role role;
	
	@Transient
	@Autowired
	private BCryptPasswordEncoder ncr;
	
	public void setPassword(String pass){
		this.password = ncr.encode(pass);
	}
	
}
