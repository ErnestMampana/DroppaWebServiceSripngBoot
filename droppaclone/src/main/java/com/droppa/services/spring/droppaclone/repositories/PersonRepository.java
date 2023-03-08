package com.droppa.services.spring.droppaclone.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.droppa.services.spring.droppaclone.models.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	Optional<Person> findByEmail(String email);

}
