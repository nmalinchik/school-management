package com.mallinapps.designdomain.service;

import java.util.UUID;

import com.mallinapps.commondto.dto.employee.Employee;
import com.mallinapps.commondto.dto.employee.EmployeeList;
import com.mallinapps.designdomain.common.PageRequest;
import com.mallinapps.designdomain.domain.employee.EmployeeEntity;
import com.mallinapps.designdomain.mapper.EmployeeMapper;
import com.mallinapps.designdomain.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeService extends CrudService<Employee, EmployeeEntity> {

    private final EmployeeMapper mapper;
    private final PositionRepository positionRepository;

    @Transactional(readOnly = true)
    public Employee findById(final UUID id) {
        return mapper.toEmployee(findEntityById(id));
    }

    @Transactional(readOnly = true)
    public EmployeeList getList(final Integer page, final Integer size) {
        return mapper.toEmployeeList(repository.findAll(), new PageRequest(page, size));
    }

    @Transactional
    public Employee create(final Employee employee) {
        var entity = mapper.toEmployeeEntity(employee);
        savePositionIfNeed(entity);
        final var saved = repository.save(entity);
        return mapper.toEmployee(saved);
    }

    @Transactional
    public Employee update(final UUID id, final Employee employee) {
        var entity = mapper.updateEmployeeEntity(employee, findEntityById(id));
        savePositionIfNeed(entity);
        var saved = repository.save(entity);
        return mapper.toEmployee(saved);
    }

    private void savePositionIfNeed(final EmployeeEntity entity) {
        if (entity.getPosition().getId() == null) {
            entity.setPosition(positionRepository.save(entity.getPosition()));
        }
        if (entity.getExtraPosition() != null && entity.getExtraPosition().getId() == null) {
            entity.setExtraPosition(positionRepository.save(entity.getExtraPosition()));
        }
    }

}
