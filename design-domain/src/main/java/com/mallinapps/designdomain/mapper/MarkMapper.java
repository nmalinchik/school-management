package com.mallinapps.designdomain.mapper;

import java.util.List;

import com.mallinapps.commondto.dto.academicperformance.Mark;
import com.mallinapps.commondto.dto.academicperformance.MarkList;
import com.mallinapps.commondto.dto.academicperformance.MarkShort;
import com.mallinapps.commondto.dto.common.CommonPageResource;
import com.mallinapps.designdomain.common.PageRequest;
import com.mallinapps.designdomain.domain.academicperformance.MarkEntity;
import com.mallinapps.designdomain.domain.employee.EmployeeEntity;
import com.mallinapps.designdomain.domain.lesson.LessonEntity;
import com.mallinapps.designdomain.domain.student.StudentEntity;
import liquibase.repackaged.org.apache.commons.collections4.CollectionUtils;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {LessonMapper.class, EmployeeMapper.class, StudentMapper.class},
        builder = @Builder(disableBuilder = true))
public interface MarkMapper {

    default MarkList toMarkList(List<MarkEntity> markEntities, PageRequest pageRequest) {
        return new MarkList(markEntities.stream()
                                      .map(this::toMark)
                                      .skip(pageRequest.getNumberOfSkippedElements())
                                      .limit(pageRequest.isFullPageRequest() ? CollectionUtils.size(markEntities) : pageRequest.getSize())
                                      .toList(),
                              CommonPageResource.builder()
                                      .page(pageRequest.getPage())
                                      .size(pageRequest.getSize())
                                      .totalElements(CollectionUtils.size(markEntities))
                                      .build());
    }

    Mark toMark(MarkEntity entity);

    @Mapping(target = "id", source = "mark.id")
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    MarkEntity toMarkEntity(MarkShort mark, LessonEntity lesson, StudentEntity student, EmployeeEntity teacher);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    MarkEntity updateMarkEntity(MarkShort mark, @MappingTarget MarkEntity entity, LessonEntity lesson, StudentEntity student, EmployeeEntity teacher);

}
