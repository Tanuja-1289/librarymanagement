package com.capgemini.librarymanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagement.dto.BooksInventory;
import com.capgemini.librarymanagement.dto.BooksRegistration;
import com.capgemini.librarymanagement.dto.BooksTransaction;
import com.capgemini.librarymanagement.dto.Users;
import com.capgemini.librarymanagement.services.LibrarianService;

@CrossOrigin(origins = "*", allowedHeaders = "*",allowCredentials = "true")
@RestController
@RequestMapping("/librarian")
public class LibrarianController {
	@Autowired
	private LibrarianService service;

	@PostMapping("/addNewBook")
	public BooksInventory addNewBook(@RequestBody BooksInventory booksInventory) {
		return service.addNewBook(booksInventory);
	}

	@PostMapping("/updateBook")
	public BooksInventory updateBook(@RequestBody BooksInventory booksInventory) {
		return service.updateBook(booksInventory);
	}

	@DeleteMapping("/deleteBook/{bookId}")
	public boolean deleteBook(@PathVariable(name = "bookId") String bookId) {
		return service.deleteBook(bookId);
	}

	@GetMapping("/getAllBookRequest")
	public List<BooksRegistration> getBookRequest() {
		return service.getBookRequest();
	}// end of getBookRequest

	@PostMapping("/responseBookRequest/{id}")
	public BooksTransaction responseBookRequest(@PathVariable(name = "id") Integer id) {
		return service.responseBookRequest(id);
	}

	@GetMapping("/cancelBookRequest/{id}")
	public boolean cancelBookRequest(@PathVariable(name = "id") Integer id) {
		return service.cancelBookRequest(id);
	}

	@PostMapping("/addStudent")
	public Users addNewStudent(@RequestBody Users student) {
		return service.addNewStudent(student);
	}

	
	@DeleteMapping("/deleteStudent/{id}")
	public boolean deleteLibrarian(@PathVariable(name = "id") String studentId) {
		return service.deleteStudent(studentId);
	}
	
	@GetMapping("/searchStudent")
	public List<Users> searchStudent() {
		return service.searchStudent();
	}
	@PutMapping("/updateStudent")
	public Users updateStudent(@RequestBody Users student) {
		return service.updateStudent(student);
	}
}
