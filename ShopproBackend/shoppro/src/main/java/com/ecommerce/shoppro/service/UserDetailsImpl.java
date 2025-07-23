package com.ecommerce.shoppro.service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ecommerce.shoppro.domain.User;

public class UserDetailsImpl implements UserDetails {
	private String email;
	private String password;
	private Set<GrantedAuthority> authorities;
	
	public UserDetailsImpl(User user) {
		this.email=user.getEmail();
		this.password=user.getPassword();
		this.authorities=user.getRoles().stream().map(role-> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		return authorities;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return email;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}

}
