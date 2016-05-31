package com.saini.dao.impl;

import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.saini.dao.ContactUsDAO;
import com.saini.model.ContactUs;
@Repository
@PersistenceContext
public class ContactUsDAOImpl implements ContactUsDAO{

	@Autowired
	private SessionFactory sf;
	@Override
	public void contactUs(ContactUs contactUs) {
		sf.getCurrentSession().save(contactUs);
		
	}
	
}
