package com.capgemini.librarymanagement.dao;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.common.Common;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.dto.BookInventory;
import com.capgemini.librarymanagement.dto.BookRegistration;
import com.capgemini.librarymanagement.dto.BookTransaction;

@Repository
public class StudentDaoImpl implements StudentDao {

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Autowired
	private Common common;
	
	

	@Override
	public List<BookInventory> showAllBook() {
		return common.showAllBook();
	}

	@Override
	public boolean requestBook(int bookId, String studentName) {
		Random random = new Random();
		boolean requestedBook = false;
		try {
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistence");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			BookRegistration registration = new BookRegistration();
			transaction.begin();
			registration.setRegistrationId(random.nextInt(100000));
			registration.setBookId(bookId);
			registration.setStudentName(studentName);
			
			Date registrationDate = new Date();
			
			registration.setRegistrationDate(registrationDate);
			
			manager.persist(registration);
			
			transaction.commit();
			manager.close();
			registration.setRegistrationId(random.nextInt());
			registration.setBookId(bookId);
			registration.setStudentName(studentName);
			
			//setting date is pending
			
			transaction.commit();
			requestedBook = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return requestedBook;
	}

	@Override
	public List<BookTransaction> showAllBorrowed(String studentName) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistence");
		EntityManager manager = factory.createEntityManager();
		String jpql= "from BookTransaction where studentName = :name ";
		Query query = manager.createQuery(jpql);
		query.setParameter("name", studentName);
		List<BookTransaction> transactions = query.getResultList();
		manager.close();
		return transactions;
	}

	@Override
	public List<BookRegistration> showAllRequested(String studentName) {
		
		EntityManager manager = factory.createEntityManager();
		String jpql= "from BookRegistration where studentName = :name ";
		Query query = manager.createQuery(jpql);
		query.setParameter("name", studentName);
		List<BookRegistration> registrations = query.getResultList();
		manager.close();
		return registrations;
	}

	@Override
	public BookInventory searchBook(String title, String author) {
		
		EntityManager manager = factory.createEntityManager();
		String jpql = "from BookInventory where title= :bookTitle and author= :bookAuthor";
		Query query = manager.createQuery(jpql);
		query.setParameter("bookTitle", title);
		query.setParameter("bookAuthor", author);
		BookInventory  search = (BookInventory) query.getSingleResult();
		manager.close();
		return search;
	}

}
