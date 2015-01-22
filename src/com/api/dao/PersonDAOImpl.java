package com.api.dao;

import java.util.ArrayList;
import java.util.List;






import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.general.utils.Util;
import com.ideamanager.entity.Email;
import com.ideamanager.entity.Person;


@Repository
@Transactional
public class PersonDAOImpl extends AbstractDAO<Person> implements PersonDAO {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Person addPerson(Person Person) {

		return super.persist(Person);
	}

	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return super.getAll(Person.class);
	}

	public Person getPersonByID(Long ID) {
		return super.get(Person.class, ID);
	}

	public Person getMemeberByEmail(String email) {
	
		Query query = getCurrentSession().createQuery("select emailOwner from Email where lower (email) like :email ");
		query.setParameter("email", email);
		List<Person>  result = query.list();
		return Util.isNotEmpty(result)?result.get(0):null;
		
	}



}
