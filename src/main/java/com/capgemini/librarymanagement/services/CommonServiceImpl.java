package com.capgemini.librarymanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.dao.CommonDao;
import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.utility.Validator;

@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	CommonDao dao;
	
	@Autowired
	private Validator validate;


	@Override
	public Users login(Users user) {
		if(validate.password(user.getPassword())) {
			return dao.login(user);
		}else {
			return null;
		}
		
	}

}
