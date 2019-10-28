package com.capgemini.librarymanagement.dao;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.common.Common;
import com.capgemini.librarymanagement.dto.BookInventory;
import com.capgemini.librarymanagement.dto.BookRegistration;
import com.capgemini.librarymanagement.dto.BookTransaction;

@Repository
public class LibrarianDaoImpl implements LibrarianDao{

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Autowired
	private Common common;
	
	@Override
	public boolean addBook(BookInventory book) {
		Random random = new Random();
		boolean addedBook = false;
		try {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			
			book.setBookId(random.nextInt(1000));
			

			transaction.begin();
			manager.persist(book);
			transaction.commit();
			manager.close();
			addedBook = true;

		}catch (Exception e) {
			e.printStackTrace();
		}
		return addedBook;

	}

	@Override
	public boolean updateBook(BookInventory book) {
		boolean updatedBook = false;
		try {
			
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			transaction.begin();
			BookInventory update = manager.find(BookInventory.class, book.getBookId());
			update.setTitle(book.getTitle());
			update.setAuthor(book.getAuthor());
			update.setCategory(book.getCategory());
			update.setCopiesAvailable(book.getCopiesAvailable());
			manager.persist(update);
			transaction.commit();
			manager.close();
			updatedBook = true;

		}catch (Exception e) {
			e.printStackTrace();
		}
		return updatedBook;
	}

	@Override
	public boolean removeBook(int bookId) {
		boolean removedBook = false;
		try {
			
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			transaction.begin();
			BookInventory book = manager.find(BookInventory.class, bookId);
			manager.remove(book);
			transaction.commit();
			manager.close();
			removedBook = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return removedBook;
	}

	@Override
	public List<BookRegistration> showAllRegistration() {
		EntityManager manager = factory.createEntityManager();
		String jpql= "from BookRegistration ";
		Query query = manager.createQuery(jpql);
		List<BookRegistration> registrations = query.getResultList();
		manager.close();
		return registrations;
	}

	@Override
	public boolean cancelRegistration(int registrationId) {
		boolean cancelledRegistration = false;
		try {
			
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			transaction.begin();
			BookRegistration registration = manager.find(BookRegistration.class, registrationId);
			manager.remove(registration);
			transaction.commit();
			manager.close();
			cancelledRegistration = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cancelledRegistration;
	}

	@Override
	public boolean issueBook(int registrationId) {
		boolean issuedBook = false;
		Random random = new Random();
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("LibraryPersistence");
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			transaction.begin();
			BookRegistration registration = manager.find(BookRegistration.class, registrationId);
			BookInventory bookInventory = manager.find(BookInventory.class, registration.getBookId());
			bookInventory.setCopiesAvailable(bookInventory.getCopiesAvailable()-1);
			
			BookTransaction bookTransaction = new BookTransaction();
			bookTransaction.setTransactionId(random.nextInt(10000));
			bookTransaction.setStudentName(registration.getStudentName());
			bookTransaction.setBookId(bookInventory.getBookId());
			
			Date issueDate = new Date();
			bookTransaction.setIssueDate(issueDate );
			
			
			Date dueDate = Date.from(Instant.now().plusSeconds(1209600));
			bookTransaction.setDueDate(dueDate );
			bookTransaction.setTransactionId(random.nextInt());
			bookTransaction.setStudentName(registration.getStudentName());
			
		
			manager.persist(bookTransaction);
			manager.persist(bookInventory);
			manager.remove(registration);
			transaction.commit();
			manager.close();
			issuedBook = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return issuedBook;	
	}

	@Override
	public List<BookTransaction> showAllIssued() {
		EntityManager manager = factory.createEntityManager();
		String jpql= "from BookTransaction ";
		Query query = manager.createQuery(jpql);
		List<BookTransaction> transactions = query.getResultList();
		manager.close();
		return transactions;
	}

	@Override
	public boolean returnBook(int transactionId) {
		boolean returnedBook = false;
		try {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();

			transaction.begin();
			BookTransaction bookTransaction = manager.find(BookTransaction.class, transactionId);
			BookInventory bookInventory = manager.find(BookInventory.class, bookTransaction.getBookId());
			bookInventory.setCopiesAvailable(bookInventory.getCopiesAvailable()+1);
			
			manager.persist(bookInventory);
			manager.remove(bookTransaction);
			transaction.commit();
			manager.close();
			returnedBook = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnedBook;	
	}

	@Override
	public List<BookInventory> showAllBook() {
		
		return common.showAllBook();
	}
}
