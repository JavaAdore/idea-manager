package com.ideamanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.api.dao.PersonDAO;
import com.business.facade.ProjectFacade;
import com.business.service.PersonService;
import com.general.utils.CustomException;
import com.ideamanager.entity.Email;
import com.ideamanager.entity.Person;
 
@Controller
public class HelloWorldController {
	String message = "Welcome to Spring MVC!";
 
	
	@Autowired
	private PersonDAO	 personDAO;
	
	
	@RequestMapping("/hello")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		System.out.println("in controller");
 
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		
		Person person = new Person();
		person.setForname("Mahmoud");
		
		
		
		
		 try
		 {
		Person p=	personDAO.addPerson(person);
		System.out.println();
		 }catch(Exception ex)
		 {
			 ex.printStackTrace(); 
		 }
		
		return mv;
	}
} 