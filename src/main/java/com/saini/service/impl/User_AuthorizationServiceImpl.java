package com.saini.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saini.dao.User_AuthorizationDAO;
import com.saini.model.User_Authorization;
import com.saini.service.User_AuthorizationService;
@Service
@Transactional
public class User_AuthorizationServiceImpl implements User_AuthorizationService {

	private User_AuthorizationDAO daos;
	@Override
	public void add(User_Authorization userAuth) {
		daos.add(userAuth);
		
	}

}
