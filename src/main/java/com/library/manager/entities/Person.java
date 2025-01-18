package com.library.manager.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="TLM_PERSON")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PERSON_ID")
	private long personId;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="TLM_PERSON_BOOK",
    joinColumns=
        @JoinColumn(name="PERSON_ID", referencedColumnName="PERSON_ID"),
    inverseJoinColumns=
        @JoinColumn(name="BOOK_ID", referencedColumnName="BOOK_ID")
    )
	private Set<Book> books;
	
	public String getName() {
		return firstName+" "+lastName;
	}
	
}
