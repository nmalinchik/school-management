package com.mallinapps.designdomain.service;

import java.util.UUID;

import com.mallinapps.designdomain.domain.base.BusinessEntity;
import com.mallinapps.designdomain.exception.EmptyNecessaryFieldException;
import com.mallinapps.designdomain.exception.EntityNotFoundException;
import com.mallinapps.designdomain.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class CrudService<U, E extends BusinessEntity> {

    @Autowired
    protected GenericRepository<E> repository;

    abstract U findById(UUID id);

    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }

    protected E findEntityById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Entity with id = %s, not found", id)));
    }

    protected void checkNotNullFields(UUID id, String entityName) {
        if (id == null) {
            throw new EmptyNecessaryFieldException("Empty id in " + entityName);
        }
    }
}
