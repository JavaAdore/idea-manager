/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.dao;

import com.general.utils.CustomException;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.internal.CriteriaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 
 * @author orcl
 */
@Repository
@Transactional
public abstract class AbstractDAO<T extends Serializable> {

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
	private TransactionTemplate transactionTemplate;
	T t;

	public T persist(final T serializedObjectToPersist) {

		T result = transactionTemplate.execute(new TransactionCallback<T>() {
			@Override
			public T doInTransaction(TransactionStatus ts) {

				hibernateTemplate.saveOrUpdate(serializedObjectToPersist);
				return serializedObjectToPersist;
			}
		});
		return result;

	}

	public void delete(final T serializedObjectToPersist)
			throws CustomException {
		try {
			transactionTemplate.execute(new TransactionCallback<T>() {
				@Override
				public T doInTransaction(TransactionStatus ts) {
					try {
						hibernateTemplate.delete(serializedObjectToPersist);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					return null;
				}
			});

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new CustomException("unableToDelete");
		}

	}

	public void deleteAll(final List<T> serializedObjectsToDelete) {

		transactionTemplate.execute(new TransactionCallback<T>() {
			@Override
			public T doInTransaction(TransactionStatus ts) {

				hibernateTemplate.deleteAll(serializedObjectsToDelete);

				return null;
			}
		});

	}

	public T get(Class objectClass, Long id) {
		try {

			T result = (T) hibernateTemplate.get(objectClass, id);
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public List<T> getAll(Class objectClass) {
		try {
			DetachedCriteria criteria = DetachedCriteria.forClass(objectClass);

			return (List<T>) hibernateTemplate.findByCriteria(criteria);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}
	

	public List<T> findByExample(T t) {
	
		return (List<T>) hibernateTemplate.findByExample(t);

	}
	
	public Session getCurrentSession()
	{
		return getHibernateTemplate().getSessionFactory().getCurrentSession();
	}
	
}
