package com.business.facade;

import java.util.List;









import com.business.service.PersonService;
import com.general.utils.Constants;
import com.general.utils.CustomException;
import com.general.utils.SpringUtils;
import com.general.utils.Util;
import com.ideamanager.entity.Person;

public class ProjectFacadeImpl implements ProjectFacade {

	private PersonService personService;



	


	public Person login(String email, String password) throws CustomException {

		Person person = personService.getMemeberByEmail(email);
		if (person == null) {
			throw Constants.invalidEmail;
		} else {
			if (person.getPassword() != null
					&& person.getPassword().equals(Util.encrypt(password))) {
				return person;

			} else {
				throw Constants.invalidPassword;
			}
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





	public Person register(String firstName, String lastName, String email,
			String password, String confirmPassword, String pictureURL)
			throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}
}
