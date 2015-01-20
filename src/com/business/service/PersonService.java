package com.business.service;

import java.io.Serializable;
import java.util.List;

import com.general.utils.CustomException;
import com.ideamanager.entity.Person;




public interface PersonService extends Serializable{

	/**
	 * 
	 */
	
	Person addPerson(Person Person) throws CustomException;

	List<Person> getAllPersons();

	Person getPersonByID(Long l);
	
	public Person getMemeberByEmail(String email);
	

	
}
