package com.mallinapps.designdomain.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.mallinapps.commondto.dto.employee.Position;
import com.mallinapps.commondto.dto.employee.PositionList;
import com.mallinapps.designdomain.common.PageRequest;
import com.mallinapps.designdomain.domain.employee.EmployeeEntity;
import com.mallinapps.designdomain.domain.employee.PositionEntity;
import com.mallinapps.designdomain.exception.CantBeDeletedException;
import com.mallinapps.designdomain.mapper.EmployeeMapper;
import com.mallinapps.designdomain.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
@RequiredArgsConstructor
public class PositionService extends CrudService<Position, PositionEntity> {

    private final EmployeeMapper mapper;
    private final EmployeeRepository employeeRepository;

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

    @Transactional
    @Override
    public void delete(UUID id) {
        //todo if possible delete
        var employees = employeeRepository.findByPositions(id);
        if (!employees.isEmpty()) {
            var employeeFIOs = employees.stream()
                    .map(this::getFio)
                    .collect(Collectors.joining(", "));
            throw new CantBeDeletedException("Данная должность задана для сотрудника(ов) (" + employeeFIOs + ")");
        } else {
            repository.deleteById(id);
        }
    }

    private String getFio(EmployeeEntity employee) {
        return employee.getLastName() + " " + employee.getFirstName()
                .charAt(0) + "." + employee.getMiddleName()
                .charAt(0) + ".";
    }

}
