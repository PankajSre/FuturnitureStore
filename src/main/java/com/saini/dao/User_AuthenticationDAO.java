package com.saini.dao;

import com.saini.model.User_Authentication;
import com.saini.model.User_Authorization;

public interface User_AuthenticationDAO {

	public void addUser(User_Authentication auth);
	public void addRole(User_Authorization userAuth);
}
