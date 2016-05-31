package com.saini.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saini.dao.ContactUsDAO;
import com.saini.model.ContactUs;
import com.saini.service.ContactUsService;
@Service
public class ContactUsServiceImpl implements ContactUsService {

	@Autowired
	
	private ContactUsDAO dao;
	@Override
	public void contactUs(ContactUs contactUs) {
		dao.contactUs(contactUs);
		
	}

}
