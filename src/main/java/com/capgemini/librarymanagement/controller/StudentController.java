package com.capgemini.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.dto.BookInventory;
import com.capgemini.librarymanagement.dto.BookRegistration;

import com.capgemini.librarymanagement.dto.BookInventory;
import com.capgemini.librarymanagement.dto.BookTransaction;
import com.capgemini.librarymanagement.services.StudentServices;
import com.capgemini.librarymanagement.utils.ProjectResponse;

@RestController
public class StudentController {
	@Autowired
	private StudentServices studentServices;
	
	@GetMapping("/student/searchBook")
	public BookInventory searchBook(String title, String author) {
		return studentServices.searchBook(title, author);
	}
	
	
	@GetMapping("/student/showAllBook")
	public List<BookInventory> showAllBook() {
		return studentServices.showAllBook();
	}
	
	@GetMapping("/student/showAllBorrowed")
	public List<BookTransaction> showAllBorrowed(String studentName) {
		return studentServices.showAllBorrowed(studentName);
	}
	
	@PostMapping("/student/requestBook")
	public ProjectResponse requestBook(int bookId, String studentName) {
		ProjectResponse response = new ProjectResponse();
		if (studentServices.requestBook(bookId, studentName)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Requset Sent Succesfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Requset Not Sent Succesfully");
		}
		 return response;
	}
	
	@GetMapping("/student/showAllRequested")
	public List<BookRegistration> showAllRequested(String studentName) {
		return studentServices.showAllRequested(studentName);
	}
	
}
