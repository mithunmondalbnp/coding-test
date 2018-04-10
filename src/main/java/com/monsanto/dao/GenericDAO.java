package com.monsanto.dao;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenericDAO<T, ID extends Serializable> extends MongoRepository<T, Serializable>{

}
