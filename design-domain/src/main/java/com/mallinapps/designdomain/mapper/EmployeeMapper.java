package com.mallinapps.designdomain.mapper;

import java.util.List;

import com.mallinapps.commondto.dto.common.CommonPageResource;
import com.mallinapps.commondto.dto.employee.Employee;
import com.mallinapps.commondto.dto.employee.EmployeeList;
import com.mallinapps.commondto.dto.employee.Position;
import com.mallinapps.commondto.dto.employee.PositionList;
import com.mallinapps.designdomain.common.PageRequest;
import com.mallinapps.designdomain.domain.employee.EmployeeEntity;
import com.mallinapps.designdomain.domain.employee.PositionEntity;
import liquibase.repackaged.org.apache.commons.collections4.CollectionUtils;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        builder = @Builder(disableBuilder = true))
public interface EmployeeMapper {

    default EmployeeList toEmployeeList(List<EmployeeEntity> employeeEntities, PageRequest pageRequest) {
        return new EmployeeList(employeeEntities.stream()
                                    .map(this::toEmployee)
                                    .skip(pageRequest.getNumberOfSkippedElements())
                                    .limit(pageRequest.isFullPageRequest() ? CollectionUtils.size(employeeEntities) : pageRequest.getSize())
                                    .toList(),
                                CommonPageResource.builder()
                                    .page(pageRequest.getPage())
                                    .size(pageRequest.getSize())
                                    .totalElements(CollectionUtils.size(employeeEntities))
                                    .build());
    }

    Employee toEmployee(EmployeeEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    EmployeeEntity toEmployeeEntity(Employee employee);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    EmployeeEntity updateEmployeeEntity(Employee dto, @MappingTarget EmployeeEntity entity);

    default PositionList toPositionList(List<PositionEntity> positionEntities, PageRequest pageRequest) {
        return new PositionList(positionEntities.stream()
                                        .map(this::toPosition)
                                        .skip(pageRequest.getNumberOfSkippedElements())
                                        .limit(pageRequest.isFullPageRequest() ? CollectionUtils.size(positionEntities) : pageRequest.getSize())
                                        .toList(),
                                CommonPageResource.builder()
                                        .page(pageRequest.getPage())
                                        .size(pageRequest.getSize())
                                        .totalElements(CollectionUtils.size(positionEntities))
                                        .build());
    }

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    PositionEntity toPositionEntity(Position position);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    PositionEntity updatePositionEntity(Position dto, @MappingTarget PositionEntity entity);

    Position toPosition(PositionEntity entity);

}
