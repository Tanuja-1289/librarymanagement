package com.capgemini.librarymanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.librarymanagement.dto.Users;


public class UserDaoImpl implements UsersDao {

	@Override
	public Users login(String username, String password) {
		Users user = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistence");
			EntityManager manager = factory.createEntityManager();
			user = manager.find(Users.class, username);
			manager.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

}
