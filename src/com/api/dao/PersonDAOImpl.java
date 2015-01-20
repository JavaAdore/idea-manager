package com.api.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.general.utils.Util;
import com.ideamanager.entity.Person;



public class PersonDAOImpl extends AbstractDAO<Person> implements PersonDAO {

	EntityManager entityManager = getEntityManagerFactory()
			.createEntityManager();

	public PersonDAOImpl() {
		super.setEntityManager(entityManager);
	}

	public Person addPerson(Person Person) {

		return super.persist(Person);
	}

	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return super.findAll(Person.class);
	}

	public Person getPersonByID(Long ID) {
		return super.getEntityByID(Person.class, ID);
	}

	public Person getMemeberByEmail(String email) {
		EntityTransaction transaction = getEntityManager().getTransaction();
		List<Person> result = new ArrayList();
		try {
			if (transaction.isActive() == false) {
				transaction.begin();
			}
			Query query = getEntityManager().createQuery(
					"from Person where lower(email) like :email");
			query.setParameter("email", email.toLowerCase());
			result = query.getResultList();
			Util.isNotEmpty(result);
			return Util.isNotEmpty(result) ? result.get(0) : null;
		} finally {
			transaction.commit();
		}

	}



}
