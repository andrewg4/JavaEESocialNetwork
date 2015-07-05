package net.simplesn.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;

/**
 * Created by Andrew on 05.07.2015.
 */
public abstract class AbstractDao<T extends Serializable> {

    @PersistenceContext(unitName = "SimpleSNdatasource")
    protected EntityManager entityManager;

    private Class<T> entityClass;

    public AbstractDao() {
    }

    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void persist(T entity) {
        getEntityManager().persist(entity);
    }

    public void merge(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        if (entity != null) {
            getEntityManager().remove(entity);
        }
    }

    public void remove(Object id) {
        T entity = (T) getEntityManager().find(entityClass, id);
        remove(entity);
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public void refresh(T entity) {
        getEntityManager().flush();
        getEntityManager().refresh(entity);
    }

    public TypedQuery<T> namedQuery(String queryName) {
        return getEntityManager().createNamedQuery(queryName, entityClass);
    }

    public TypedQuery<T> query(String queryString) {
        return getEntityManager().createQuery(queryString, entityClass);
    }

    public long count() {
        CriteriaQuery criteriaQuery = getEntityManager().getCriteriaBuilder().createQuery();
        Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(getEntityManager().getCriteriaBuilder().count(root));
        Query query = getEntityManager().createQuery(criteriaQuery);
        return (Long) query.getSingleResult();
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }
}

