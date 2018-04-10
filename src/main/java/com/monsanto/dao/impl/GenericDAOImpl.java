package com.monsanto.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.monsanto.dao.GenericDAO;

@Repository(GenericDAOImpl.DAO_NAME)
public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID>{

	public static final String DAO_NAME = "genericDAO";
	
	/**
	 * log variable.
	 */
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * Is Debug Enabled variable.
	 */
	protected boolean isDebugEnabled = log.isDebugEnabled();
	/**
	 * Is Warn Enabled variable.
	 */
	protected boolean isWarnEnabled = log.isWarnEnabled();
	/**
	 * Is Error Enabled variable.
	 */
	protected boolean isErrorEnabled = log.isErrorEnabled();
	/**
	 * Is Info Enabled variable.
	 */
	protected boolean isInfoEnabled = log.isInfoEnabled();
	
	/** The persistent class. */
    private Class<T> persistentClass;
	
	@Autowired
	public MongoTemplate mongoTemplate;
	
	public GenericDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public GenericDAOImpl(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public List<T> findAll() {
		return mongoTemplate.findAll(getPersistentClass());
	}

	public List<T> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends T> List<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<T> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends T> S save(S entity) {
		log.debug("Saving entity");
		mongoTemplate.save(entity);
		return entity;
	}

	public T findOne(Serializable id) {
		return mongoTemplate.findById(id, getPersistentClass());
	}

	public boolean exists(Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterable<T> findAll(Iterable<Serializable> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void delete(Serializable id) {
	}

	public void delete(T entity) {
		mongoTemplate.remove(entity);
	}

	public void delete(Iterable<? extends T> entities) {
		mongoTemplate.remove(entities);
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public <S extends T> S insert(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S extends T> List<S> insert(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
