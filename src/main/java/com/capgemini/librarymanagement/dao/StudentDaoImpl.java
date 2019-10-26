package com.capgemini.librarymanagement.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.dto.BookInventory;
import com.capgemini.librarymanagement.dto.BookRegistration;
import com.capgemini.librarymanagement.dto.BookTransaction;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Override
	public BookInventory searchBook(int bookId) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistence");
		EntityManager manager = factory.createEntityManager();
		
		BookInventory searchedBook = manager.find(BookInventory.class, bookId);
		manager.close();
		
		return searchedBook;
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
	public boolean requestBook(int bookId, String studentName) {
		Random random = new Random();
		boolean requestedBook = false;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistence");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			BookRegistration registration = new BookRegistration();
			transaction.begin();
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

}
