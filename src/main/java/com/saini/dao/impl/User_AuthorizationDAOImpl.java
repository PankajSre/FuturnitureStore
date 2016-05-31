package com.saini.dao.impl;

import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.saini.dao.User_AuthorizationDAO;
import com.saini.model.User_Authorization;

@Repository
@PersistenceContext
public class User_AuthorizationDAOImpl implements User_AuthorizationDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public void add(User_Authorization userAuth) {
		sf.getCurrentSession().save(userAuth);
		
	}


}
