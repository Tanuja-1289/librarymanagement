package com.capgemini.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.librarymanagement.dto.BookInventory;
import com.capgemini.librarymanagement.dto.BookTransaction;
import com.capgemini.librarymanagement.services.StudentServices;
import com.capgemini.librarymanagement.utils.ProjectResponse;

public class StudentController {
	@Autowired
	private StudentServices studentServices;
	
	@GetMapping("/student/searchBook")
	public BookInventory searchBook(int bookId) {
		return studentServices.searchBook(bookId) ;
	}
	
	@GetMapping("/student/showAllBook")
	public List<BookInventory> showAllBook() {
		return studentServices.showAllBook();
	}
	
	@GetMapping("/student/showAllBorrowed")
	public List<BookTransaction> showAllBorrowed(String studentName) {
		return studentServices.showAllBorrowed(studentName);
	}
	
	@PostMapping("/student/requsetBook")
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
	
	
}
