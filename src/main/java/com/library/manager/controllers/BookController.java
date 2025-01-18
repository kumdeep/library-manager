package com.library.manager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.manager.entities.Book;
import com.library.manager.models.BookAddRequest;
import com.library.manager.services.BookService;

@RequestMapping("/api/books")
@RestController
public class BookController {

	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping
	public List<Book> findAllBooks(){
		return bookService.findAllBooks();
	}
	
	@GetMapping("/id/{bookId}")
	public Book findBookById(@PathVariable long bookId) {
		return bookService.findBookById(bookId);
	}
	
	@GetMapping("/name")
	public List<Book> findBookByName(@RequestParam("name") String bookName){
		return bookService.findBookByName(bookName);
	}
	
	@PostMapping
	public Book addNewBook(@RequestBody BookAddRequest bookAddRequest) {
		return bookService.addnewBook(bookAddRequest);
	}
	
	@DeleteMapping("/id/{bookId}")
	public boolean deleteBookById(@PathVariable long bookId){
		return bookService.deleteBookById(bookId);
		
	}
	
}
