package com.cadena.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cadena.dao.UserDao;
import com.cadena.model.User;

import javassist.bytecode.stackmap.BasicBlock.Catch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService { // -Integration point with Spring Security.

	@Autowired
	UserDao userDao;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String username) {
		try {
			System.out.println("____ UserDetailsServiceImpl 28");
			com.cadena.model.User cadenaUser = userDao.findUserByUsername(username);
			UserBuilder builder = null;
			System.out.println("____ UserDetailsServiceImpl 31");
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			System.out.println("____ UserDetailsServiceImpl 33");
			builder.password(cadenaUser.getPassword());
			String[] authorities = cadenaUser.getAuthorities().stream().map(a -> a.getAuthority())
					.toArray(String[]::new);
			builder.authorities(authorities);
			System.out.println("____ UserDetailsServiceImpl 38");
			return builder.build();
		} catch (UsernameNotFoundException ex) {
			throw new UsernameNotFoundException("User not found.", ex);
		}
	}

	public UserDetailsServiceImp() {
		super();
	}

}
