package com.kamil.loginDemo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.kamil.loginDemo.role.Role;

import lombok.Data;

@Data
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
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;

	@NotNull
	@Column(unique=true)
	private String firstName;

	@NotNull
	@Column(unique=true)
	private String secondName;
	
	@Email
	@NotNull
	@Column(unique=true)
	public String mail;
	
	@NotNull
	public String password;
	
	@NotNull
	private boolean banned = false;
	
	@OneToOne
	public Role role;
	
}
