package com.library.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.manager.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
