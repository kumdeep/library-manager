package com.library.manager.services;

import java.util.List;

import com.library.manager.entities.Book;
import com.library.manager.models.BookAddRequest;

public interface BookService {
	
	public List<Book> findAllBooks();
	public Book findBookById(long id);
	public List<Book> findBookByName(String name);
	public List<Book> findBookByAuthorName(String authorName);
	
	public Book addnewBook(BookAddRequest bookAddRequest);
	public boolean deleteBookById(long bookId);
	public boolean deleteBooksByName(String bookName);
	
}
