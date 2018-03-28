package com.cadena.dao;

import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import com.cadena.model.User;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public User findUserByUsername(String username) {

		TypedQuery<User> query = sessionFactory.getCurrentSession()
				.createQuery("from User u where u.username=:username");
		query.setParameter("username", username);

		List<User> users = query.getResultList();
		if (users.isEmpty()) {
			System.out.println("____ UserDaoImpl 28");
			throw new UsernameNotFoundException("User does not exist");
		} else {
			System.out.println("____ UserDaoImpl 31");
			return users.get(0);
		}

		// return sessionFactory.getCurrentSession().get(User.class, username);
	}

}
