package com.capgemini.librarymanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagement.dao.UsersDao;
import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.utils.ValidatorImplementation;

@Service
public class UsersServicesImpl implements UserServices{

	@Autowired
	UsersDao dao;

	@Autowired
	ValidatorImplementation regex;


	@Override
	public Users login(String username, String password) {

		if(regex.validatePassword(password)) {
			return dao.login(username, password);
		}else {
			return null;
		}
	}
}
