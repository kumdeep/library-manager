package com.library.manager.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.manager.entities.Person;
import com.library.manager.exceptions.UnimplementedException;
import com.library.manager.models.PersonAddRequest;
import com.library.manager.repository.PersonRepository;
import com.library.manager.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;
	
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public Person addNewPerson(PersonAddRequest personAddRequest) {
		return personRepository.save(
			Person.builder()
			.firstName(personAddRequest.getFirstName())
			.lastName(personAddRequest.getLastName())
			.build()
		);
	}

	@Override
	public boolean deletePerson(long personId) {
		try{
			personRepository.deleteById(personId);
		}
		catch(Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public List<Person> findAllPerson() {
		return personRepository.findAll();
	}

	@Override
	public List<Person> findPersonsByName() {
		throw new UnimplementedException();
	}

	@Override
	public Person findPersonById(long personId) {
		return personRepository.findById(personId).orElse(null);
	}

}
