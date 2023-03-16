package com.sda.practicalproject.repositories.base;

import com.sda.practicalproject.repositories.exception.EntityUpdateFailedException;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {

    void save(T entity) throws EntityUpdateFailedException;

    void update(T entity) throws EntityUpdateFailedException;

    void delete(T entity) throws EntityUpdateFailedException;

    Optional<T> findById(long id);

    List<T> findAll();
}
