package com.capgemini.librarymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.dto.Users;

@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	private static final String ROLE = "Librarian";

	@Override
	public Users addLibrarian(Users librarian) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			
			librarian.setRole(ROLE);
			
			entityManager.persist(librarian);
			
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			transaction.rollback();
		}
		return librarian;
	}

	@Override
	public Users updateLibrarian(Users librarian) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Users updatedLibrarian = entityManager.find(Users.class, librarian.getId());
		try {
			transaction.begin();
			
			if (updatedLibrarian != null) {
				updatedLibrarian.setId(librarian.getId());
				updatedLibrarian.setName(librarian.getName());
				updatedLibrarian.setEmailId(librarian.getEmailId());
				updatedLibrarian.setPassword(librarian.getPassword());
				updatedLibrarian.setRole(ROLE);
				transaction.commit();
				entityManager.close();
			}
		} catch (Exception e) {
			transaction.rollback();
		}
		return updatedLibrarian;
	}

	@Override
	public boolean deleteLibrarian(String librarianId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean deletedLibrarian = false;
		try {
			Users users = null;
			users = entityManager.find(Users.class, librarianId);
			if (users != null) {
				transaction.begin();
				
				entityManager.remove(users);
				
				transaction.commit();
				entityManager.close();
				deletedLibrarian = true;
			}
		} catch (Exception e) {
			transaction.rollback();
		}
		return deletedLibrarian;
	}

	@Override
	public List<Users> searchLibrarian() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<Users> users = null;
		try {
			String jpql = "from Users where role=: role";
			
			Query getDetailsQuery = entityManager.createQuery(jpql);
			getDetailsQuery.setParameter("role", ROLE);
			users = getDetailsQuery.getResultList();
			
			entityManager.close();
		}catch (Exception e) {
			transaction.rollback();
		}
		return users;
	}
}