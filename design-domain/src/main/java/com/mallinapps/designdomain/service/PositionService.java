package com.mallinapps.designdomain.service;

import java.util.UUID;

import com.mallinapps.commondto.dto.employee.Position;
import com.mallinapps.commondto.dto.employee.PositionList;
import com.mallinapps.designdomain.common.PageRequest;
import com.mallinapps.designdomain.domain.employee.PositionEntity;
import com.mallinapps.designdomain.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PositionService extends CrudService<PositionList, Position, PositionEntity> {

    private final EmployeeMapper mapper;

    public PositionList getList(Integer page, Integer size) {
        log.info("get position list for selected page");
        return mapper.toPositionList(repository.findAll(), new PageRequest(page, size));
    }

    public Position findById(final UUID id) {
        log.info("find position by id {}", id);
        return mapper.toPosition(findEntityById(id));
    }

    public Position create(final Position position) {
        log.info("create position from dto: {}", position);
        final var positionEntity = mapper.toPositionEntity(position);
        var saved = repository.save(positionEntity);
        return mapper.toPosition(saved);
    }

    public Position update(final UUID id, final Position position) {
        log.info("update position with id {} with dto: {}", id, position);
        final var entity = mapper.updatePositionEntity(position, findEntityById(id));
        var saved = repository.save(entity);
        return mapper.toPosition(saved);
    }

}
