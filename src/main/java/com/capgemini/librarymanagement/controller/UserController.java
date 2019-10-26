package com.capgemini.librarymanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.services.UserServices;

@RestController
public class UserController {

	@Autowired
	private UserServices userServices;
	
	@PostMapping("/login")
	public Users login(String username, String password) {
		return userServices.login(username, password);
	}
	
}
