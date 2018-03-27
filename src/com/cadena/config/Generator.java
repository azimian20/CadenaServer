package com.cadena.config;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.cadena.model.Authorities;
import com.cadena.model.User;

public class Generator {

	public static void main(String[] args) {
		/*HibernateConfig hConfig = new HibernateConfig();
		Session session = hConfig.getTransactionManager().getSessionFactory().openSession();
		User user = new User();
		user.setUsername("jon");
		user.setPassword(new BCryptPasswordEncoder().encode("123"));
		Authorities authorities = new Authorities();
		authorities.setAuthority("ROLE_ADMIN");
		Set<Authorities> authoritiesSet = new HashSet<>();
		authoritiesSet.add(authorities);
		user.setAuthorities(authoritiesSet);
		session.save(user);
		session.close();
		System.out.println("user inserted");*/
		System.out.println(new BCryptPasswordEncoder().encode("123"));

	}
	
	/*
	 * 
insert into T_DOMAINENTITY(id,C_DESCRIPTION) values(1,'user admin');
insert into T_PERSON(id,C_LNAME,C_FNAME) values(1,'Ferei', 'jon');
insert into T_USER(id,C_USERNAME,C_PASSWORD) values(1, 'jon', '$2a$10$JwJtPkeEWBjctypZv7mwheRIb5JwXdKtRRBucNdnZuKRpUuFLKutG');
insert into T_DOMAINENTITY(id,C_DESCRIPTION) values(2,'role admin');
insert into T_AUTHORITIES(id,C_AUTHORITY,C_USER) values(2,'ROLE_ADMIN',1);
	 */

}
