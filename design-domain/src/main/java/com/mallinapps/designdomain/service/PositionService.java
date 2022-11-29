package com.mallinapps.designdomain.service;

import java.util.UUID;

import com.mallinapps.commondto.dto.employee.Position;
import com.mallinapps.commondto.dto.employee.PositionList;
import com.mallinapps.designdomain.common.PageRequest;
import com.mallinapps.designdomain.domain.employee.PositionEntity;
import com.mallinapps.designdomain.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PositionService extends CrudService<Position, PositionEntity> {

    private final EmployeeMapper mapper;

    @Transactional(readOnly = true)
    public PositionList getList(Integer page, Integer size) {
        return mapper.toPositionList(repository.findAll(), new PageRequest(page, size));
    }

    @Transactional(readOnly = true)
    public Position findById(final UUID id) {
        return mapper.toPosition(findEntityById(id));
    }

    @Transactional
    public Position create(final Position position) {
        final var positionEntity = mapper.toPositionEntity(position);
        var saved = repository.save(positionEntity);
        return mapper.toPosition(saved);
    }

    @Transactional
    public Position update(final UUID id, final Position position) {
        final var entity = mapper.updatePositionEntity(position, findEntityById(id));
        var saved = repository.save(entity);
        return mapper.toPosition(saved);
    }

}
