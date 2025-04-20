package com.learnlogic.ecommerce.merabazar.database.common.daoImpl;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learnlogic.ecommerce.merabazar.database.common.dao.GenericDao;

@Repository
@Transactional
public class EntityManagerDao<EntityType, IDType extends Serializable> implements GenericDao<EntityType, IDType> {

    @Autowired
    private SessionFactory sessionFactory;
	
	 private Class<EntityType> persistentClass ;
	
	    public Class<EntityType> getPersistentClass() {
	        return persistentClass;
	    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
	
	public EntityType retrieveById(IDType id) {
        return getSession().get(getPersistentClass(), id);
	}	

	@SuppressWarnings("unchecked")
	public IDType create(EntityType entity) {
        return (IDType) getSession().save(entity);
	}

	public void createOrUpdate(EntityType entity) {
        getSession().saveOrUpdate(entity);
	}

	public void update(EntityType entity) {
        getSession().update(entity);
	}

	public void delete(EntityType entity) {
        getSession().delete(entity);
	}

	public void deleteById(IDType id) {
        EntityType entity = retrieveById(id);
        if (entity != null) {
            delete(entity);
        }
	}

    @SuppressWarnings("unchecked")
	public List<EntityType> retrieveAll() {
        return getSession().createQuery("from " + getPersistentClass().getName()).list();
	}

    @SuppressWarnings("unchecked")
	public List<EntityType> findAll(String orderBy) {
        return getSession().createQuery("from " + getPersistentClass().getName() + " order by " + orderBy).list();
	}

    @SuppressWarnings("unchecked")
	public List<EntityType> findFiltered(String property, Object filter) {
        return getSession().createQuery("from " + getPersistentClass().getName() + " where " + property + " = :filter")
                .setParameter("filter", filter)
                .list();
	}

    @SuppressWarnings("unchecked")
    public List<EntityType> findFiltered(String property, Object filter, String orderBy) {
        return getSession().createQuery("from " + getPersistentClass().getName() + " where " + property + " = :filter order by " + orderBy)
                .setParameter("filter", filter)
                .list();
	}

    @SuppressWarnings("unchecked")
	public List<EntityType> findLikeFiltered(String property, Object filter) {
        return getSession().createQuery("from " + getPersistentClass().getName() + " where " + property + " like :filter")
                .setParameter("filter", "%" + filter + "%")
                .list();
	}

    @SuppressWarnings("unchecked")
    public List<EntityType> findLikeFiltered(String property, Object filter, String orderBy) {
        return getSession().createQuery("from " + getPersistentClass().getName() + " where " + property + " like :filter order by " + orderBy)
                .setParameter("filter", "%" + filter + "%")
                .list();
	}

    @SuppressWarnings("unchecked")
	public EntityType findUniqueFiltered(String property, Object filter) {
        return (EntityType) getSession().createQuery("from " + getPersistentClass().getName() + " where " + property + " = :filter")
                .setParameter("filter", filter)
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public EntityType findUniqueFiltered(String property, Object filter, String orderBy) {
        return (EntityType) getSession().createQuery("from " + getPersistentClass().getName() + " where " + property + " = :filter order by " + orderBy)
                .setParameter("filter", filter)
                .uniqueResult();
	}

    @SuppressWarnings("unchecked")
    public List<EntityType> findByCriteria(Predicate... predicates) {
        return findByCriteriaList(List.of(predicates));
	}

    @SuppressWarnings("unchecked")
    public List<EntityType> findByCriteriaList(List<Predicate> predicates) {
        return findByCriteriaList(predicates, false);
	}

    @SuppressWarnings("unchecked")
    public List<EntityType> findByCriteriaList(List<Predicate> predicates, Boolean isSearch) {
        Session session = getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<EntityType> cq = cb.createQuery(getPersistentClass());
        Root<EntityType> root = cq.from(getPersistentClass());

        if (predicates != null && !predicates.isEmpty()) {
            cq.where(predicates.toArray(new Predicate[0]));
	}

        if (isSearch) {
            cq.distinct(true);
	} 

        return session.createQuery(cq).getResultList();
    }
}
