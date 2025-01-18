package com.library.manager.services;

import java.util.List;

import com.library.manager.entities.Person;
import com.library.manager.models.PersonAddRequest;

public interface PersonService {

	public Person addNewPerson(PersonAddRequest personAddRequest);
	public boolean deletePerson(long personId);
	
	public List<Person> findAllPerson();
	public List<Person> findPersonsByName();
	public Person findPersonById(long personId);
}
