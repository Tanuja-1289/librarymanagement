package com.capgemini.librarymanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.dto.Users;

@Repository
public class UsersDaoImpl implements UsersDao {

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
