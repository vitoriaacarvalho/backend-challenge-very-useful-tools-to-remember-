package com.vitoria.models;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name="users_table")
public class Users implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Type(type="uuid-char")
	private UUID id;
	
	@Column(unique=true)
	private String login;
	
	@Column(unique=true)
	private String email; 
	
	private String password;
	
	@ManyToMany
	private List<Roles> role; 
	
	public Users() {
	}
	
	public Users(UUID id, String login, String email, String password, List<Roles> role) {
		this.id = id;
		this.login = login;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Roles> getRole() {
		return role;
	}

	public void setRole(List<Roles> role) {
		this.role = role;
	}
	
	
	
}
