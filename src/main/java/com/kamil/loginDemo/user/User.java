package com.kamil.loginDemo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kamil.loginDemo.role.Role;

@Entity
public class User {

	public User() {
		this.banned = false;
	}

	public User(String firstName, String secondName, String mail, Role role, String password) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.mail = mail;
		this.role = role;
		this.password = password;
	}

	public User(String firstName, String secondName, String mail, Role role, String password, boolean banned) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.mail = mail;
		this.role = role;
		this.password = password;
		this.banned = banned;
	}
	@Transient
	private BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;

	@Column(nullable = false)
	public String firstName;
	@Column(nullable = false)
	public String secondName;

	@Email
	@Column(nullable = false, unique = true)
	public String mail;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	public boolean banned = false;

	@OneToOne
	public Role role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public boolean isBanned() {
		return banned;
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = passEncoder.encode(password);
	}
	
	
	

}
