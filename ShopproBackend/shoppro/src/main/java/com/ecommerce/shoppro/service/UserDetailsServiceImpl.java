package com.ecommerce.shoppro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecommerce.shoppro.domain.User;
import com.ecommerce.shoppro.repo.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String email)throws UsernameNotFoundException{
		User user=userRepository.findByEmail(email).orElseThrow(()-> new
				UsernameNotFoundException("User Not Found"));
		return new UserDetailsImpl(user);
	}

}
