package com.business.facade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.general.utils.CustomException;
import com.ideamanager.entity.Person;


@Service
public interface ProjectFacade  {
	


	List<Person> getAllPersons();

	Person getPersonByID(Long l); 
	
	Person login(String email , String password)throws CustomException ;
	
	Person register(String firstName, String lastName, String email, String password, String confirmPassword, String pictureURL) throws CustomException ;
	


	
}
