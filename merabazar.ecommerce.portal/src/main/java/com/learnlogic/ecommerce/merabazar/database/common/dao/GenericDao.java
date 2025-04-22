package com.learnlogic.ecommerce.merabazar.database.common.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {

    T findById(ID id);

    ID create(T entity);

    T createOrUpdate(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(ID id);

    List<T> findAll();

    List<T> findAll(String orderBy);

    List<T> findFiltered(String property, Object filter);

    List<T> findFiltered(String property, Object filter, String orderBy);

    List<T> findLikeFiltered(String property, Object filter);

    List<T> findLikeFiltered(String property, Object filter, String orderBy);

    T findUniqueFiltered(String property, Object filter);

    T findUniqueFiltered(String property, Object filter, String orderBy);

    List<T> findByAttributes(String jpql, Object... params);
	
    List<T> findByAttributes(String jpql, List<Object> params);
	
    List<T> findByAttributes(String jpql, List<Object> params, boolean isSearch);
}
