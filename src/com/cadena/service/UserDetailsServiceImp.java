package com.cadena.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cadena.dao.UserDao;
import com.cadena.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService { // -Integration point with Spring Security.

	
	
	@Autowired
	UserDao userDao;
	
	
	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) {
		System.out.println("____ UserDetailsServiceImpl 28");
		com.cadena.model.User cadenaUser = userDao.findUserByUsername(username);

		UserBuilder builder = null;
		if (cadenaUser != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
		      builder.password(cadenaUser.getPassword());
		      String[] authorities = cadenaUser.getAuthorities()
		          .stream().map(a -> a.getAuthority()).toArray(String[]::new);

		      builder.authorities(authorities);
		      System.out.println("____ UserDetailsServiceImpl 39");
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
		return builder.build();
	}

	public UserDetailsServiceImp() {
		super();
	}

	

}
