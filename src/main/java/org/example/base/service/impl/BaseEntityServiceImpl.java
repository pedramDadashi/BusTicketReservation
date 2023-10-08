package org.example.base.service.impl;

import org.example.base.domain.BaseEntity;
import org.example.base.repository.BaseEntityRepository;
import org.example.base.service.BaseEntityService;

import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class BaseEntityServiceImpl<T extends BaseEntity<ID>, ID extends Serializable, REPOSITORY extends BaseEntityRepository<T, ID>>
        implements BaseEntityService<T, ID> {

    private final REPOSITORY repository;

    public BaseEntityServiceImpl(REPOSITORY repository) {
        this.repository = repository;
    }

    @Override
    public void save(T t) {
        EntityTransaction transaction = repository.getEntityManager().getTransaction();
        transaction.begin();
        repository.save(t);
        transaction.commit();
    }

    @Override
    public void delete(T t) {
        EntityTransaction transaction = repository.getEntityManager().getTransaction();
        transaction.begin();
        repository.delete(t);
        transaction.commit();
    }


    // it may have some problems
    @Override
    public void deleteById(ID id) {
        EntityTransaction transaction = repository.getEntityManager().getTransaction();
        transaction.begin();
        if (repository.findById(id).isPresent()){
            repository.delete(repository.findById(id).get());
        }
        transaction.commit();
    }

    @Override
    public Optional<T> findById(ID id) {
        EntityTransaction transaction = repository.getEntityManager().getTransaction();
        transaction.begin();
        Optional<T> optional = repository.findById(id);
        transaction.commit();
        return optional;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(T t) {
        EntityTransaction transaction = repository.getEntityManager().getTransaction();
        transaction.begin();
        repository.update(t);
        transaction.commit();
    }

    @Override
    public long count() {
        return repository.count();
    }


}
