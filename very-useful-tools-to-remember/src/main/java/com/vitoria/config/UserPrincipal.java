package com.vitoria.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vitoria.models.Roles;
import com.vitoria.models.Users;

public class UserPrincipal implements UserDetails{
	private String login;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	public static UserPrincipal create(Users user) {
		return new UserPrincipal(user);
	}
	
	public UserPrincipal(Users user) {
		this.login = login;
		this.password = password;
		this.authorities = authorities;
		List<SimpleGrantedAuthority> authorities=new ArrayList<>();
		List<Roles> roles=user.getRole();
		for (Roles role : roles)
		    authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		this.authorities=authorities;
		
	}

	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
