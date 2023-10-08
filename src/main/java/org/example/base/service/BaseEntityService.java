package org.example.base.service;

import org.example.base.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseEntityService <T extends BaseEntity<ID>, ID extends Serializable> extends Serializable{

    void save(T t);

    void delete(T t);

    void deleteById(ID id);

    Optional<T> findById(ID id);

    List<T> findAll();

    void update(T t);

    long count();

}
