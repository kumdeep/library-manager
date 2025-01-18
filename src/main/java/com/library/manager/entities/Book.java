package com.library.manager.entities;

import java.sql.Timestamp;
import java.util.Set;

import com.library.manager.models.BookGenre;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TLM_BOOK")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOK_ID")
	private long bookId;
	
	@Column(name = "BOOK_NAME")
	private String bookName;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {})
	private Set<Person> authors;
	
	@Column(name = "PUBLISHED_ON")
	private Timestamp publishedDate;
	
	@Column(name = "BOOK_GENRE")
	private BookGenre bookGenre;
	
	@Column(name = "BOOK_PRICE")
	private double bookPrice;
	
}
