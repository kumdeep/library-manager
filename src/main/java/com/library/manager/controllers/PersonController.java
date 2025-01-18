package com.library.manager.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.manager.entities.Person;
import com.library.manager.models.PersonAddRequest;
import com.library.manager.services.PersonService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/persons")
public class PersonController {

	private PersonService personService;
	
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@GetMapping
	public List<Person> findAllPersons(){
		return personService.findAllPerson();
	}
	
	@PostMapping
	public Person addNewPerson(@RequestBody PersonAddRequest personAddRequest) {
		return personService.addNewPerson(personAddRequest);
	}
	
	@DeleteMapping("/id/{id}")
	public boolean deleteBookById(@PathVariable long id) throws IOException {
		return personService.deletePerson(id);
	}
}
