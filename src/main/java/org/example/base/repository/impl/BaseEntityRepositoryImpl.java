package org.example.base.repository.impl;

import org.example.base.domain.BaseEntity;
import org.example.base.repository.BaseEntityRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


public abstract class BaseEntityRepositoryImpl<T extends BaseEntity<ID>, ID extends Serializable> implements BaseEntityRepository<T, ID> {

    private final EntityManager em;

    public BaseEntityRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void save(T t) {
        if (t.getId() == null) {
            em.persist(t);
        } else {
            em.merge(t);
        }
    }

    @Override
    public void delete(T t) {
        em.remove(t);
    }

    @Override
    public void deleteById(ID id) {
        try {
            em.remove(findById(id));
        } catch (Exception e) {
            throw new RuntimeException("entity not found");
        }
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(em.find(getEntityClass(), id));
    }

    @Override
    public List<T> findAll() {
        return em.createQuery(" from " + getEntityClass().getSimpleName(), getEntityClass()).getResultList();
    }

    @Override
    public void update(T t) {
        em.merge(t);
    }

    @Override
    public long count() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cbQuery = cb.createQuery(long.class);
        TypedQuery<Long> query = em.createQuery(cbQuery);
        cbQuery.select(cb.count(cbQuery.from(getEntityClass())));
        return em.createQuery(cbQuery).getSingleResult();
    }

    private Integer countLikes() {
        return em.createQuery(
                "select count(e) from " + getEntityClass().getSimpleName() + " e",
                Integer.class
        ).getSingleResult();
    }

    @Override
    public void beginTransaction() {
        EntityTransaction transaction = em.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
    }

    @Override
    public void commitTransaction() {
        EntityTransaction transaction = em.getTransaction();
        if (transaction.isActive()) {
            transaction.commit();
        }
    }

    @Override
    public void rollbackTransaction() {
        EntityTransaction transaction = em.getTransaction();
        if (transaction.isActive()) {
            transaction.rollback();
        }
    }

    public abstract Class<T> getEntityClass();
}
