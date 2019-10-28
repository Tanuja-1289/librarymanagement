package com.capgemini.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.dto.BookInventory;
import com.capgemini.librarymanagement.dto.BookRegistration;
import com.capgemini.librarymanagement.dto.BookTransaction;
import com.capgemini.librarymanagement.services.AdminServices;
import com.capgemini.librarymanagement.services.LibrarianServices;
import com.capgemini.librarymanagement.utils.ProjectResponse;

@RestController
public class LibrarianController {

	@Autowired
	private LibrarianServices librarianServices;
	
	@PostMapping("/librarian/addBook")
	public ProjectResponse addBook(BookInventory book) {
		ProjectResponse response = new ProjectResponse();
		if (librarianServices.addBook(book)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Book Added Succesfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Book Not Added Succesfully");
		}
		
		return response;
	}
	
	@PostMapping("/librarian/updateBook")
	public ProjectResponse updateBook(BookInventory book) {
		ProjectResponse response = new ProjectResponse();
		if (librarianServices.updateBook(book)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Book Updated Succesfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Book Not Updated Succesfully");
		}
		
		return response;
	}
	
	@PostMapping("/librarian/removeBook")
	public ProjectResponse removeBook(int bookId) {
		ProjectResponse response = new ProjectResponse();
		if (librarianServices.removeBook(bookId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Book Removed Succesfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Book Not Removed Succesfully");
		}
		return response;
	}
	
	@GetMapping("/librarian/showAllBook")
	public List<BookInventory> showAllBook() {
		return librarianServices.showAllBook();
	}
	
	@GetMapping("/librarian/showAllIssued")
	public List<BookTransaction> showAllIssued() {
		return librarianServices.showAllIssued();
	}
	
	@GetMapping("/librarian/showAllRegistration")
	public List<BookRegistration> showAllRegistration() {
		return librarianServices.showAllRegistration();
	}
	
	@PostMapping("/librarian/issueBook")
	public ProjectResponse issueBook(int registrationId) {
		ProjectResponse response = new ProjectResponse();
		if (librarianServices.issueBook(registrationId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Book Issued Succesfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Book Not Issued Succesfully");
		}
		
		return response;
	}
	
	@PostMapping("/librarian/cancelRegistration")
	public ProjectResponse cancelRegistration(int registrationId) {
		ProjectResponse response = new ProjectResponse();
		if (librarianServices.cancelRegistration(registrationId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Registration Cancelled Succesfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Registration Not Cancelled Succesfully");
		}
		return response;
	}
	
	@PostMapping("/librarian/returnBook")
	public ProjectResponse returnBook(int transactionId) {
		ProjectResponse response = new ProjectResponse();
		if (librarianServices.returnBook(transactionId)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Book Returned Succesfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Book Not Returned Succesfully");
		}
		return response;
	}
}
