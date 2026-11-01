package com.jvlcode.spring_boot_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name="users	")
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String username;
	private String password;
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEntity(String password, String username, String email, String name, Long id) {
		this.password = password;
		this.username = username;
		this.email = email;
	 	this.name = name;
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public void merge(UserEntity user){
		if(!Objects.equals(null,user.getName())){
			this.setName(user.getName());
		}
		if(!Objects.equals(null,user.getEmail())){
			this.setEmail(user.getEmail());
		}
		if(!Objects.equals(null,user.getUsername())){
			this.setUsername(user.getUsername());
		}
		if(!Objects.equals(null,user.getPassword())){
			this.setPassword(user.getPassword());
		}
	}

	
}
