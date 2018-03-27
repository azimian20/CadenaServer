package com.cadena.dao;

import com.cadena.model.User;

public interface UserDao {
	User findUserByUsername(String username);
}
