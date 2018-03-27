package com.cadena.dao;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.cadena.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findUserByUsername(String username) {
		
		System.out.println("____ UserDaoImpl 21");
		
		User cadenaUser = (User)sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username").setParameter("username", username).getSingleResult();
		if(cadenaUser==null) {
			throw new UsernameNotFoundException("User does not exist");
		}
		System.out.println("____ UserDaoImpl 27");
		return cadenaUser;
		
		
		
		//return sessionFactory.getCurrentSession().get(User.class, username);
	}

}
