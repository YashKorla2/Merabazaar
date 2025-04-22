package com.learnlogic.ecommerce.merabazar.database.common.daoImpl;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learnlogic.ecommerce.merabazar.database.common.dao.GenericDao;

@Repository
@Transactional
public class EntityManagerDao<EntityType, IDType extends Serializable> implements GenericDao<EntityType, IDType> {

    @PersistenceContext
    protected EntityManager entityManager;
	
	 private Class<EntityType> persistentClass ;
	
    public EntityManagerDao(Class<EntityType> persistentClass) {
        this.persistentClass = persistentClass;
    }
	
	    public Class<EntityType> getPersistentClass() {
	        return persistentClass;
	    }

    @Override
    public EntityType findById(IDType id) {
        return entityManager.find(getPersistentClass(), id);
	}	

    @Override
	public IDType create(EntityType entity) {
        entityManager.persist(entity);
        return (IDType) entityManager.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(entity);
	}

    @Override
    public EntityType createOrUpdate(EntityType entity) {
        return entityManager.merge(entity);
	}

    @Override
    public EntityType update(EntityType entity) {
        return entityManager.merge(entity);
	}

    @Override
	public void delete(EntityType entity) {
        entityManager.remove(entity);
	}

    @Override
	public void deleteById(IDType id) {
        EntityType entity = findById(id);
        if (entity != null) {
            delete(entity);
        }
	}

    @Override
    public List<EntityType> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EntityType> cq = cb.createQuery(getPersistentClass());
        Root<EntityType> rootEntry = cq.from(getPersistentClass());
        CriteriaQuery<EntityType> all = cq.select(rootEntry);
        TypedQuery<EntityType> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
	}

    @Override
	public List<EntityType> findAll(String orderBy) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EntityType> cq = cb.createQuery(getPersistentClass());
        Root<EntityType> rootEntry = cq.from(getPersistentClass());
        CriteriaQuery<EntityType> all = cq.select(rootEntry).orderBy(cb.asc(rootEntry.get(orderBy)));
        TypedQuery<EntityType> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
	}

    @Override
	public List<EntityType> findFiltered(String property, Object filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EntityType> cq = cb.createQuery(getPersistentClass());
        Root<EntityType> rootEntry = cq.from(getPersistentClass());
        CriteriaQuery<EntityType> all = cq.select(rootEntry).where(cb.equal(rootEntry.get(property), filter));
        TypedQuery<EntityType> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public List<EntityType> findFiltered(String property, Object filter, String orderBy) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EntityType> cq = cb.createQuery(getPersistentClass());
        Root<EntityType> rootEntry = cq.from(getPersistentClass());
        CriteriaQuery<EntityType> all = cq.select(rootEntry)
                .where(cb.equal(rootEntry.get(property), filter))
                .orderBy(cb.asc(rootEntry.get(orderBy)));
        TypedQuery<EntityType> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
	}

    @Override
	public List<EntityType> findLikeFiltered(String property, Object filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EntityType> cq = cb.createQuery(getPersistentClass());
        Root<EntityType> rootEntry = cq.from(getPersistentClass());
        CriteriaQuery<EntityType> all = cq.select(rootEntry).where(cb.like(rootEntry.get(property), "%" + filter + "%"));
        TypedQuery<EntityType> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public List<EntityType> findLikeFiltered(String property, Object filter, String orderBy) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EntityType> cq = cb.createQuery(getPersistentClass());
        Root<EntityType> rootEntry = cq.from(getPersistentClass());
        CriteriaQuery<EntityType> all = cq.select(rootEntry)
                .where(cb.like(rootEntry.get(property), "%" + filter + "%"))
                .orderBy(cb.asc(rootEntry.get(orderBy)));
        TypedQuery<EntityType> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
	}

    @Override
	public EntityType findUniqueFiltered(String property, Object filter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EntityType> cq = cb.createQuery(getPersistentClass());
        Root<EntityType> rootEntry = cq.from(getPersistentClass());
        CriteriaQuery<EntityType> all = cq.select(rootEntry).where(cb.equal(rootEntry.get(property), filter));
        TypedQuery<EntityType> allQuery = entityManager.createQuery(all);
        List<EntityType> results = allQuery.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public EntityType findUniqueFiltered(String property, Object filter, String orderBy) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<EntityType> cq = cb.createQuery(getPersistentClass());
        Root<EntityType> rootEntry = cq.from(getPersistentClass());
        CriteriaQuery<EntityType> all = cq.select(rootEntry)
                .where(cb.equal(rootEntry.get(property), filter))
                .orderBy(cb.asc(rootEntry.get(orderBy)));
        TypedQuery<EntityType> allQuery = entityManager.createQuery(all);
        List<EntityType> results = allQuery.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }

    @Override
    public List<EntityType> findByAttributes(String jpql, Object... params) {
        TypedQuery<EntityType> query = entityManager.createQuery(jpql, getPersistentClass());
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
        return query.getResultList();
    }

    @Override
    public List<EntityType> findByAttributes(String jpql, List<Object> params) {
        TypedQuery<EntityType> query = entityManager.createQuery(jpql, getPersistentClass());
        for (int i = 0; i < params.size(); i++) {
            query.setParameter(i + 1, params.get(i));
        }
        return query.getResultList();
    }

    @Override
    public List<EntityType> findByAttributes(String jpql, List<Object> params, boolean isSearch) {
        TypedQuery<EntityType> query = entityManager.createQuery(jpql, getPersistentClass());
        for (int i = 0; i < params.size(); i++) {
            query.setParameter(i + 1, isSearch ? "%" + params.get(i) + "%" : params.get(i));
	}
        return query.getResultList();
	}
}
