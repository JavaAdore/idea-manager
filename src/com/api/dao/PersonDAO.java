 package com.api.dao;

import java.io.Serializable;
import java.util.List;

import com.ideamanager.entity.Person;




public interface PersonDAO extends Serializable{

	/**
	 * 
	 */
	
	Person addPerson(Person Person);

	List<Person> getAllPersons();

	Person getPersonByID(Long l);

	Person getMemeberByEmail(String email);
	
	
	 

}
