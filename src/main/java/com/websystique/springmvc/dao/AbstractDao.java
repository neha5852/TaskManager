package com.websystique.springmvc.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable, T , K> {
	
	private final Class<T> persistentClass;
	private final Class<K> persistentClass1;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		this.persistentClass1 =(Class<K>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}
	
	@SuppressWarnings("unchecked")
	public K getByKey1(PK key) {
		return (K) getSession().get(persistentClass1, key);
	}

	public void persist(T entity) {
		getSession().persist(entity);
	}
	
	public void persist1(K entity) {
		getSession().persist(entity);
	}

	public void update(T entity) {
		getSession().update(entity);
	}
	
	public void update1(K entity) {
		getSession().update(entity);
	}

	public void delete(T entity) {
		getSession().delete(entity);
	}
	
	public void delete1(K entity) {
		getSession().delete(entity);
	}
	
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}
	
	protected Criteria createEntityCriteria1(){
		return getSession().createCriteria(persistentClass1);
	}

	protected Criteria createOwnerEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}
	
	protected Criteria createOwnerEntityCriteria1(){
		return getSession().createCriteria(persistentClass1);
	}
	
}
