package com.capgemini.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.dto.BookInventory;
import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.services.AdminServices;
import com.capgemini.librarymanagement.utils.ProjectResponse;

@RestController
public class AdminController {

	@Autowired
	private AdminServices adminServices;
	
	@PostMapping("/admin/addLibrarian")
	public ProjectResponse addLibrarian(String username, String password) {
		ProjectResponse response = new ProjectResponse();
		if(adminServices.addLibrarian(username, password)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Librarian Added Succesfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Librarian Not Added Succesfully");
		}
		return response;
	}
	
	@PostMapping("/admin/addStudent")
	public ProjectResponse addStudent(String username, String password) {
		ProjectResponse response = new ProjectResponse();
		if(adminServices.addStudent(username, password)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Student Added Succesfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Student Not Added Succesfully");
		}
		return response;
	}
	
	@PostMapping("/admin/removeLibrarian")
	public ProjectResponse removeLibrarian(String username) {
		ProjectResponse response = new ProjectResponse();
		if(adminServices.removeLibrarian(username)){
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Librarian Removed Succesfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Librarian Not Removed Succesfully");
		}
		return response;
	}
	@PostMapping("/admin/removeStudent")
	public ProjectResponse removeStudent(String username) {
		ProjectResponse response = new ProjectResponse();
		if(adminServices.removeStudent(username)){
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Student Removed Succesfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Student Not Removed Succesfully");
		}
		return response;
	}
	
	@GetMapping("/admin/showAllLibrarian")
	public List<Users> showAllLibrarian() {
		return adminServices.showAllLibrarian();
	}
	
	@GetMapping("/admin/showAllStudent")
	public List<Users> showAllStudent() {
		return adminServices.showAllStudent();
	}
}
