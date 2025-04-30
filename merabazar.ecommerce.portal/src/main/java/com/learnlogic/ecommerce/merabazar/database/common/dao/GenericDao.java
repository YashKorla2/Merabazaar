package com.learnlogic.ecommerce.merabazar.database.common.dao;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.criteria.Predicate;

public interface GenericDao<T, ID extends Serializable> {

	 public T retrieveById(ID id);

	    public ID create(T entity);

	    public void createOrUpdate(T entity);

	    public void update(T entity);

	    public void delete(T entity);

	    public void deleteById(ID id);

	    public List<T> retrieveAll();

	    public List<T> findAll(String orderBy);

	    public List<T> findFiltered(String property, Object filter);

	    public List<T> findFiltered(String property, Object filter, String orderBy);

	    public List<T> findLikeFiltered(String property, Object filter);

	    public List<T> findLikeFiltered(String property, Object filter, String orderBy);

	    public T findUniqueFiltered(String property, Object filter);

	    public T findUniqueFiltered(String property, Object filter, String orderBy);

    public List<T> findByCriteria(Predicate... predicates);
	
    public List<T> findByCriteriaList(List<Predicate> predicates);
	
    public List<T> findByCriteriaList(List<Predicate> predicates, Boolean isSearch);
}
