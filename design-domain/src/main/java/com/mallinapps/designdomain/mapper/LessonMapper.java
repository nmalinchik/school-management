package com.mallinapps.designdomain.mapper;

import java.util.List;

import com.mallinapps.commondto.dto.common.CommonPageResource;
import com.mallinapps.commondto.dto.lesson.Lesson;
import com.mallinapps.commondto.dto.lesson.LessonList;
import com.mallinapps.designdomain.common.PageRequest;
import com.mallinapps.designdomain.domain.lesson.LessonEntity;
import liquibase.repackaged.org.apache.commons.collections4.CollectionUtils;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        builder = @Builder(disableBuilder = true))
public interface LessonMapper {

    default LessonList toLessonList(List<LessonEntity> lessonEntities, PageRequest pageRequest) {
        return new LessonList(lessonEntities.stream()
                                        .map(this::toLesson)
                                        .skip(pageRequest.getNumberOfSkippedElements())
                                        .limit(pageRequest.isFullPageRequest() ? CollectionUtils.size(lessonEntities) : pageRequest.getSize())
                                        .toList(),
                                CommonPageResource.builder()
                                        .page(pageRequest.getPage())
                                        .size(pageRequest.getSize())
                                        .totalElements(CollectionUtils.size(lessonEntities))
                                        .build());
    }

    Lesson toLesson(LessonEntity entity);

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    LessonEntity toLessonEntity(Lesson lesson);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    LessonEntity updateLessonEntity(Lesson lesson, @MappingTarget LessonEntity entity);
}
