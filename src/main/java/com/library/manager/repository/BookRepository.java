package com.library.manager.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;

import com.library.manager.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

	List<Book> findBookByBookName(String name);

	@Modifying
	void deleteBookByBookName(String bookName);

}
