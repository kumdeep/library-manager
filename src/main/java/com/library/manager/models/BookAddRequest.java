package com.library.manager.models;

import java.sql.Timestamp;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookAddRequest {

	private String bookName;
	private Set<Long> authorIds;
	private Timestamp publishedDate;
	private BookGenre bookGenre;
	private double bookPrice;
}
