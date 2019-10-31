package com.capgemini.librarymanagement.dao;

import java.util.Calendar;
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
import com.capgemini.librarymanagement.dto.Users;

@Repository
public class LibrarianDaoImpl implements LibrarianDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;
	
	private static final String ROLE = "Student";
	
	@Override
	public BooksInventory addNewBook(BooksInventory booksInventory) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(booksInventory);
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			transaction.rollback();
		}
		return booksInventory;
	}

	@Override
	public BooksInventory updateBook(BooksInventory booksInventory) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		BooksInventory selecetdBook = null;
		try {
			transaction.begin();
			selecetdBook = entityManager.find(BooksInventory.class, booksInventory.getBookId());
			selecetdBook.setBookName(booksInventory.getBookName());
			selecetdBook.setfirstAuthor(booksInventory.getfirstAuthor());
			selecetdBook.setsecondAuthor(booksInventory.getsecondAuthor());
			selecetdBook.setPublisher(booksInventory.getPublisher());
			selecetdBook.setYearofpublication(booksInventory.getYearOfPublication());
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		return selecetdBook;
	}

	@Override
	public boolean deleteBook(String bookId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean deletedBook = false;
		try {
			BooksInventory booksInventory = null;
			booksInventory = entityManager.find(BooksInventory.class, bookId);
			if (booksInventory != null) {
				transaction.begin();
				entityManager.remove(booksInventory);
				transaction.commit();
				entityManager.close();
				deletedBook = true;
			}
		} catch (Exception e) {
			transaction.rollback();
		}
		entityManager.close();
		return deletedBook ;
	}

	@Override
	public List<BooksRegistration> getBookRequest() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<BooksRegistration> registeredBooks = null;
		try {
			transaction.begin();
			String jpql = "from BooksRegistration";
			Query getDetailsQuery = entityManager.createQuery(jpql);
			registeredBooks = getDetailsQuery.getResultList();
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			transaction.rollback();
		}
		return registeredBooks;
	}

	@Override
	public boolean cancelBookRequest(int registrationId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		BooksRegistration booksRegistration = entityManager.find(BooksRegistration.class, registrationId);
		boolean cancelledRequest= false;
		try {
			if (booksRegistration != null) {
				transaction.begin();
				entityManager.remove(booksRegistration);
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
	public Users addNewStudent(Users student) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			if(student.getRole() == null) {
			student.setRole("Student");
			entityManager.persist(student);
			transaction.commit();
			entityManager.close();
			}
		} catch (Exception e) {
			transaction.rollback();
		}
		return student;
	}

	@Override
	public List<Users> searchStudent() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		List<Users> users = null;
		try {
			transaction.begin();
			
			String jpql = "from Users where role=: role ";
			Query searchQuery = entityManager.createQuery(jpql);
			searchQuery.setParameter("role", ROLE);
			
			users = searchQuery.getResultList();
			
			entityManager.getTransaction().commit();
			entityManager.close();
		} catch (Exception e) {
			transaction.rollback();
		}
		return users;
	}

	@Override
	public boolean deleteStudent(String studentId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		boolean deletedStudent = false;
		try {
			Users users = null;
			users = entityManager.find(Users.class, studentId);
			if (users != null) {
				transaction.begin();
				
				entityManager.remove(users);
				
				transaction.commit();
				entityManager.close();
				deletedStudent = true;
			}
		} catch (Exception e) {
			transaction.rollback();
		}
		return deletedStudent;
	}

	@Override
	public BooksTransaction responseBookRequest(int registrationId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		BooksTransaction booksTransaction = new BooksTransaction();
		try {
			transaction.begin();
			Random random = new Random();
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, 15);
			Date returnDate = calendar.getTime();
			BooksRegistration booksRegistration = entityManager.find(BooksRegistration.class, registrationId);
			
			booksTransaction.setTransactionId(random.nextInt(1000));
			booksTransaction.setRegistrationId(registrationId);
			booksTransaction.setIssueDate(new Date());
			booksTransaction.setReturnDate(returnDate);
			booksTransaction.setFine(0);
			booksTransaction.setStudentId(booksRegistration.getUserId());
			
			entityManager.persist(booksTransaction);
			entityManager.remove(booksRegistration);
			transaction.commit();
			entityManager.close();
		} catch (Exception e) {
			transaction.rollback();
		}

		return booksTransaction;
	}

	@Override
	public Users updateStudent(Users student) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		Users updatedStudent = entityManager.find(Users.class, student.getId());
		try {
			transaction.begin();
			
			if (updatedStudent != null) {
				updatedStudent.setId(student.getId());
				updatedStudent.setName(student.getName());
				updatedStudent.setEmailId(student.getEmailId());
				updatedStudent.setPassword(student.getPassword());
				updatedStudent.setRole(ROLE);
				transaction.commit();
				entityManager.close();
			}
		} catch (Exception e) {
			transaction.rollback();
		}
		return updatedStudent;
	}
}
