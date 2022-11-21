package com.mallinapps.commondto.mapstruct;

import com.mallinapps.commondto.dto.academicperformance.Mark;
import com.mallinapps.designdomain.domain.academicperformance.MarkEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        uses = {LessonMapper.class, EmployeeMapper.class, StudentMapper.class},
        builder = @Builder(disableBuilder = true))
public interface MarkMapper {

    Mark toMark(MarkEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    MarkEntity toMarkEntity(Mark mark);

}
