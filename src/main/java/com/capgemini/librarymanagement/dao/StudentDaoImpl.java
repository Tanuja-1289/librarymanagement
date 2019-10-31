package com.capgemini.librarymanagement.dao;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.BooksTransaction;

@Repository
public class StudentDaoImpl implements StudentDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	@Override
	public List<BooksInventory> searchForBook(String bookName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<BooksInventory> booksInventory = null;
		try {
			transaction.begin();
			String jpql = "from BooksInventory where bookName=: bookName ";
			Query searchQuery = entityManager.createQuery(jpql);
			searchQuery.setParameter("bookName", bookName);
			
			booksInventory = searchQuery.getResultList();
			
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			transaction.rollback();
		}
		return booksInventory;
	}

	@Override
	public BooksRegistration makeBookRequest(String bookId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		BooksRegistration registration = new BooksRegistration();
		try {
			transaction.begin();
			Random random = new Random();

			registration.setRegistrationId(random.nextInt(500));
			registration.setUserId(CommonDaoImpl.userId);
			registration.setBookId(bookId);
			registration.setRegistrationDate(new Date());
			
			entityManager.persist(registration);
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			transaction.rollback();
		}
		return registration;
	}

	@Override
	public boolean cancelRequestedBook(int registrationId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		BooksRegistration registration = entityManager.find(BooksRegistration.class, registrationId);
		boolean cancelledRequest = false;
		try {
			if (registration != null) {
				transaction.begin();
				entityManager.remove(registration);
				transaction.commit();
				entityManager.close();
				cancelledRequest = true;
			}
		} catch (Exception e) {
			transaction.rollback();
		}
		return cancelledRequest;
	}

	@Override
	public List<BooksTransaction> getResponse() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<BooksTransaction> booksTransaction = null;
		try {
			transaction.begin();
			String jpql = "from BooksTransaction where studentId=: studentId";
			Query getDetailsQuery = entityManager.createQuery(jpql);
			
			getDetailsQuery.setParameter("studentId", CommonDaoImpl.userId);
			booksTransaction = getDetailsQuery.getResultList();
			transaction.commit();
			
			entityManager.close();
		} catch (Exception e) {
			transaction.rollback();
		}
		return booksTransaction;
	}

	@Override
	public List<BooksRegistration> getAllRequestedBook() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<BooksRegistration> registeredBooks = null;
		try {
			transaction.begin();
			String jpql = "from BooksRegistration where userId=: userId ";
			Query getDetailsQuery = entityManager.createQuery(jpql);
			getDetailsQuery.setParameter("userId", CommonDaoImpl.userId);
			registeredBooks = getDetailsQuery.getResultList();
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			transaction.rollback();
		}
		return registeredBooks;
	}

	@Override
	public boolean returnBook(int transactionId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean returnedBook = false;
		try {
			transaction.begin();
			BooksTransaction booksTransaction = null;
			booksTransaction = entityManager.find(BooksTransaction.class, transactionId);
			
			Date returnDate = booksTransaction.getReturnDate();
			Date todayDate = new Date();
			
			long days = (todayDate.getTime() - returnDate.getTime()) / (1000 * 60 * 60 * 24);
			
			if (days > 0) {
				int fine = (int) days * 2;
				booksTransaction.setFine(fine);
			} else {
				booksTransaction.setFine(0);
			}
			entityManager.remove(booksTransaction);
			transaction.commit();
			entityManager.close();
			returnedBook = true;
		} catch (Exception e) {
			transaction.rollback();
		}
		return returnedBook;
	}

}
