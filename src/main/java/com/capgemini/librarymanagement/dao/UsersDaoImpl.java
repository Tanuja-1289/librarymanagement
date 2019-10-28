package com.capgemini.librarymanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.dto.Users;

@Repository
public class UsersDaoImpl implements UsersDao {

	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public Users login(String username, String password) {
		Users user=null;
		try {

			EntityManager manager = factory.createEntityManager();
			user = manager.find(Users.class, username);
			manager.close();
			if(user.getPassword().equals(password)) {
				return user;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
