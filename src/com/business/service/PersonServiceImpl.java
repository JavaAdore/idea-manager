package com.business.service;

import java.util.List;

import com.general.utils.Constants;
import com.general.utils.CustomException;
import com.ideamanager.entity.Person;
import com.api.dao.*;

public class PersonServiceImpl implements PersonService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	PersonDAO PersonDAO;

	
	public Person addPerson(Person member) throws CustomException {
		try {
			if (false /*exist*/) {
				return PersonDAO.addPerson(member);
			} else {
				throw Constants.EMAIL_ALREADY_EXISTS;

			}
		} catch (CustomException ex) {
			throw ex;
		} catch (Exception ex) {
			throw Constants.DATABASE_ERROR;

		}
	}

	
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Person getPersonByID(Long l) {
		// TODO Auto-generated method stub
		return null;
	}

	public  Person getMemeberByEmail(String email) {
		return PersonDAO.getMemeberByEmail(email);
	}

	
 
}
