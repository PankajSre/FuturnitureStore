package com.saini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saini.dao.User_AuthenticationDAO;
import com.saini.model.User_Authentication;
import com.saini.model.User_Authorization;
import com.saini.service.User_AuthenticationService;

@Service
@Transactional
public class User_AuthenticationServiceImpl implements
		User_AuthenticationService {

	@Autowired
	private User_AuthenticationDAO dao;

	@Override
	public void addUser(User_Authentication auth) {
		dao.addUser(auth);

	}

	@Override
	public void addRole(User_Authorization userAuth) {

		dao.addRole(userAuth);

	}

}
