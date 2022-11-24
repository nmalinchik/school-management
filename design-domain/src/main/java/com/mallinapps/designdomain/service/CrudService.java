package com.mallinapps.designdomain.service;

import java.util.UUID;

import com.mallinapps.designdomain.domain.base.BusinessEntity;
import com.mallinapps.designdomain.exception.EntityNotFoundException;
import com.mallinapps.designdomain.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CrudService<T,U, E extends BusinessEntity> {

    @Autowired
    protected GenericRepository<E> repository;

    abstract T getList(Integer page, Integer size);
    abstract U findById(UUID id);
    abstract U create(U position);
    abstract U update(UUID id, U position);

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    protected E findEntityById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Entity with id = %s, not found", id)));
    }
}
