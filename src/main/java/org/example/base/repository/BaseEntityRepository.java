package org.example.base.repository;

import org.example.base.domain.BaseEntity;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseEntityRepository<T extends BaseEntity<ID>, ID extends Serializable> {

    void save(T t);

    void delete(T t);

    void deleteById(ID id);

    Optional<T> findById(ID id);

    List<T> findAll();

    void update(T t);

    long count();

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();

    EntityManager getEntityManager();

}
