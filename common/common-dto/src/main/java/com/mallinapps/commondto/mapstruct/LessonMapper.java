package com.mallinapps.commondto.mapstruct;

import com.mallinapps.commondto.dto.lesson.Lesson;
import com.mallinapps.designdomain.domain.lesson.LessonEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        builder = @Builder(disableBuilder = true))
public interface LessonMapper {

    Lesson toLesson(LessonEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    LessonEntity toLessonEntity(Lesson lesson);

}
