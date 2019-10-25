package com.capgemini.librarymanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.librarymanagement.dto.BookInventory;
import com.capgemini.librarymanagement.dto.BookRegistration;
import com.capgemini.librarymanagement.dto.BookTransaction;
import com.capgemini.librarymanagement.dto.Users;

public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean addLibrarian(String username, String password) {
		boolean addedLibrarian = false;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistence");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			transaction.begin();
			Users librarian = new Users();
			librarian.setUsername(username);
			librarian.setPassword(password);
			librarian.setType('L');
			manager.persist(librarian);
			transaction.commit();
			manager.close();
			addedLibrarian = true;

		}catch (Exception e) {
			e.printStackTrace();
		}
		return addedLibrarian;
	}

	@Override
	public boolean removeLibrarian(String username) {
		boolean removedLibrarian = false;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistence");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			transaction.begin();
			Users librarian = manager.find(Users.class, username);
			manager.remove(librarian);
			transaction.commit();
			manager.close();
			removedLibrarian = true;

		}catch (Exception e) {
			e.printStackTrace();
		}
		return removedLibrarian;
	}

	@Override
	public List<Users> showAllLibrarian() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql= "Select username from Users where type='L'";
		Query query = manager.createQuery(jpql);
		List<Users> librarians = query.getResultList();
		manager.close();
		return librarians;
	}

	@Override
	public boolean addStudent(String username, String password) {
		boolean addedStudent = false;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistence");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			transaction.begin();
			Users student = new Users();
			student.setUsername(username);
			student.setPassword(password);
			student.setType('S');
			manager.persist(student);
			transaction.commit();
			manager.close();
			addedStudent = true;

		}catch (Exception e) {
			e.printStackTrace();
		}
		return addedStudent;
	}

	@Override
	public boolean removeStudent(String username) {
		boolean removedStudent = false;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistence");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			transaction.begin();
			Users student = manager.find(Users.class, username);
			manager.remove(student);
			transaction.commit();
			manager.close();
			removedStudent = true;

		}catch (Exception e) {
			e.printStackTrace();
		}
		return removedStudent;
	}

	@Override
	public List<Users> showAllStudent() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql= "Select username from Users where type='S'";
		Query query = manager.createQuery(jpql);
		List<Users> students = query.getResultList();
		manager.close();
		return students;
	}

	@Override
	public List<BookInventory> showAllBook() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql= "from BookInventory ";
		Query query = manager.createQuery(jpql);
		List<BookInventory> books = query.getResultList();
		manager.close();
		return books;

	}

	@Override
	public List<BookRegistration> showAllRegistration() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql= "from BookRegistration ";
		Query query = manager.createQuery(jpql);
		List<BookRegistration> registrations = query.getResultList();
		manager.close();
		return registrations;
	}

	@Override
	public List<BookTransaction> showAllTransaction() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql= "from BookTransaction ";
		Query query = manager.createQuery(jpql);
		List<BookTransaction> transactions = query.getResultList();
		manager.close();
		return transactions;
	}

}
