package com.learnlogic.ecommerce.merabazar.database.common.daoImpl;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.learnlogic.ecommerce.merabazar.database.common.dao.GenericDao;

// Hint for Q: Implement logging mechanisms to track all requests
// Hint for Q: Implement validations wherever necessary
// Hint for Q: Use async-await if possible

@Repository
public class EntityManagerDao<EntityType, IDType extends Serializable> implements GenericDao<EntityType, IDType> {

    @PersistenceContext
    protected EntityManager entityManager;
	
	 private Class<EntityType> persistentClass ;
	
	    public Class<EntityType> getPersistentClass() {
	        return persistentClass;
	    }

	public EntityType retrieveById(IDType id) {
        return entityManager.find(getPersistentClass(), id);
	}	

	public IDType create(EntityType entity) {
        entityManager.persist(entity);
        return (IDType) entityManager.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);
	}

	public void createOrUpdate(EntityType entity) {
        entityManager.merge(entity);
	}

	public void update(EntityType entity) {
        entityManager.merge(entity);
	}

	public void delete(EntityType entity) {
        entityManager.remove(entity);
	}

	public void deleteById(IDType id) {
        EntityType entity = retrieveById(id);
        if (entity != null) {
            delete(entity);
        }
	}

	public List<EntityType> retrieveAll() {
        CriteriaQuery<EntityType> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(getPersistentClass());
        criteriaQuery.from(getPersistentClass());
        return entityManager.createQuery(criteriaQuery).getResultList();
	}

	public List<EntityType> findAll(String orderBy) {
        // Implementation depends on how you want to handle ordering
        return retrieveAll();
	}

	public List<EntityType> findFiltered(String property, Object filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EntityType> criteriaQuery = cb.createQuery(getPersistentClass());
        Root<EntityType> root = criteriaQuery.from(getPersistentClass());
        criteriaQuery.where(cb.equal(root.get(property), filter));
        return entityManager.createQuery(criteriaQuery).getResultList();
	}

    public List<EntityType> findFiltered(String property, Object filter, String orderBy) {
        // Implementation depends on how you want to handle ordering
        return findFiltered(property, filter);
	}

	public List<EntityType> findLikeFiltered(String property, Object filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EntityType> criteriaQuery = cb.createQuery(getPersistentClass());
        Root<EntityType> root = criteriaQuery.from(getPersistentClass());
        criteriaQuery.where(cb.like(root.get(property), "%" + filter + "%"));
        return entityManager.createQuery(criteriaQuery).getResultList();
	}

    public List<EntityType> findLikeFiltered(String property, Object filter, String orderBy) {
        // Implementation depends on how you want to handle ordering
        return findLikeFiltered(property, filter);
	}

	public EntityType findUniqueFiltered(String property, Object filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EntityType> criteriaQuery = cb.createQuery(getPersistentClass());
        Root<EntityType> root = criteriaQuery.from(getPersistentClass());
        criteriaQuery.where(cb.equal(root.get(property), filter));
        TypedQuery<EntityType> query = entityManager.createQuery(criteriaQuery);
        List<EntityType> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0);
	}

    public EntityType findUniqueFiltered(String property, Object filter, String orderBy) {
        // Implementation depends on how you want to handle ordering
        return findUniqueFiltered(property, filter);
	}

    public List<EntityType> findByCriteria(Predicate... predicates) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EntityType> criteriaQuery = cb.createQuery(getPersistentClass());
        Root<EntityType> root = criteriaQuery.from(getPersistentClass());
        criteriaQuery.where(predicates);
        return entityManager.createQuery(criteriaQuery).getResultList();
	}

    public List<EntityType> findByCriteriaList(List<Predicate> predicates) {
        return findByCriteria(predicates.toArray(new Predicate[0]));
	}

    public List<EntityType> findByCriteriaList(List<Predicate> predicates, Boolean isSearch) {
        // Implementation depends on how you want to handle the isSearch parameter
        return findByCriteriaList(predicates);
	} 
}
