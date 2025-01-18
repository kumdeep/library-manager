package com.library.manager.services.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.library.manager.entities.Book;
import com.library.manager.exceptions.UnimplementedException;
import com.library.manager.models.BookAddRequest;
import com.library.manager.repository.BookRepository;
import com.library.manager.repository.PersonRepository;
import com.library.manager.services.BookService;

@Service
public class BookServiceImpl implements BookService{

	private BookRepository bookRepository;
	private PersonRepository personRepository;
	
	public BookServiceImpl(BookRepository bookRepository, PersonRepository personRepository) {
		this.bookRepository = bookRepository;
		this.personRepository = personRepository;
	}

	@Override
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book findBookById(long id) {
		return bookRepository.findById(id).orElse(null);
	}

	@Override
	public List<Book> findBookByName(String name) {
		return bookRepository.findBookByBookName(name);
	}

	@Override
	public List<Book> findBookByAuthorName(String authorName) {
		throw new UnimplementedException();
	}

	@Override
	public Book addnewBook(BookAddRequest bookAddRequest) {
		return bookRepository.save(
			Book.builder()
			.authors(Set.of())
			.bookGenre(bookAddRequest.getBookGenre())
			.bookName(bookAddRequest.getBookName())
			.bookPrice(bookAddRequest.getBookPrice())
			.publishedDate(bookAddRequest.getPublishedDate())
			.authors(personRepository
					.findAllById(bookAddRequest.getAuthorIds())
					.stream()
					.collect(Collectors.toSet()))
			.build()
		);
	}

	@Override
	public boolean deleteBookById(long bookId) {
		try{
			bookRepository.deleteById(bookId);
		}
		catch(Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteBooksByName(String bookName) {
		try{
			bookRepository.deleteBookByBookName(bookName);
		}
		catch(Exception ex) {
			return false;
		}
		return true;
	}

}
