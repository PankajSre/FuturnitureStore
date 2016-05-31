package com.saini.dao.impl;

import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.saini.dao.User_AuthenticationDAO;
import com.saini.model.User_Authentication;
import com.saini.model.User_Authorization;
@Repository
@PersistenceContext
public class User_AuthenticationDAOImpl implements User_AuthenticationDAO{

	@Autowired
	private SessionFactory sf;

	@Override
	public void addUser(User_Authentication auth) {
		sf.getCurrentSession().save(auth);
		
	}

	@Override
	public void addRole(User_Authorization userAuth) {
		sf.getCurrentSession().save(userAuth);
		
	}
	

}
