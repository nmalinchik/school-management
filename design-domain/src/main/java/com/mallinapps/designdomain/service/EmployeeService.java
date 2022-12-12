package com.mallinapps.designdomain.service;

import java.util.UUID;

import com.mallinapps.commondto.dto.employee.Employee;
import com.mallinapps.commondto.dto.employee.EmployeeList;
import com.mallinapps.commondto.dto.employee.EmployeeShort;
import com.mallinapps.designdomain.common.PageRequest;
import com.mallinapps.designdomain.domain.employee.EmployeeEntity;
import com.mallinapps.designdomain.domain.employee.PositionEntity;
import com.mallinapps.designdomain.mapper.EmployeeMapper;
import com.mallinapps.designdomain.repository.PositionRepository;
import liquibase.repackaged.org.apache.commons.lang3.tuple.Pair;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeService extends CrudService<Employee, EmployeeEntity> {

    private final EmployeeMapper mapper;
    private final PositionService positionService;

    @Transactional(readOnly = true)
    public Employee findById(final UUID id) {
        return mapper.toEmployee(findEntityById(id));
    }

    @Transactional(readOnly = true)
    public EmployeeList getList(final Integer page, final Integer size) {
        return mapper.toEmployeeList(repository.findAll(), new PageRequest(page, size));
    }

    @Transactional
    public Employee create(final EmployeeShort employee) {
        var positions = getPositions(employee);
        var entity = mapper.toEmployeeEntity(employee, positions.getLeft(), positions.getRight());
        return mapper.toEmployee(repository.save(entity));
    }

    @Transactional
    public Employee update(final UUID id, final EmployeeShort employee) {
        var positions = getPositions(employee);
        var entity = mapper.updateEmployeeEntity(employee, findEntityById(id), positions.getLeft(), positions.getRight());
        return mapper.toEmployee(repository.save(entity));
    }

    private Pair<PositionEntity, PositionEntity> getPositions(EmployeeShort dto) {
        checkNotNullFields(dto.positionId(), "position");
        var extraPosition = dto.extraPositionId() != null ? positionService.findEntityById(dto.extraPositionId()) : null;
        return Pair.of(positionService.findEntityById(dto.positionId()), extraPosition);
    }

}
