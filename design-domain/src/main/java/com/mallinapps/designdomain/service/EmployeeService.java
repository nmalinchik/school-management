package com.mallinapps.designdomain.service;

import java.util.UUID;

import com.mallinapps.commondto.dto.employee.Employee;
import com.mallinapps.commondto.dto.employee.EmployeeList;
import com.mallinapps.designdomain.common.PageRequest;
import com.mallinapps.designdomain.domain.employee.EmployeeEntity;
import com.mallinapps.designdomain.mapper.EmployeeMapper;
import com.mallinapps.designdomain.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService extends CrudService<EmployeeList, Employee, EmployeeEntity> {

    private final EmployeeMapper mapper;
    private final PositionRepository positionRepository;

    public Employee findById(final UUID id) {
        log.info("find entity with id {}", id);
        var entity = findEntityById(id);
        return mapper.toEmployee(entity);
    }

    public EmployeeList getList(final Integer page, final Integer size) {
        log.info("get employee list for selected page");
        return mapper.toEmployeeList(repository.findAll(), new PageRequest(page, size));
    }

    public Employee create(final Employee employee) {
        log.info("create employee from dto:{}", employee);
        var entity = mapper.toEmployeeEntity(employee);
        savePositionIfNeed(entity);
        final var saved = repository.save(entity);
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

    public Employee update(final UUID id, final Employee employee) {
        log.info("update employee with id = {} from dto:{}", id, employee);
        var entity = mapper.updateEmployeeEntity(employee, findEntityById(id));
        savePositionIfNeed(entity);
        var saved = repository.save(entity);
        return mapper.toEmployee(saved);
    }

}
