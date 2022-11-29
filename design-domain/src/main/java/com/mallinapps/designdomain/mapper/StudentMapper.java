package com.mallinapps.designdomain.mapper;

import java.util.List;

import com.mallinapps.commondto.dto.common.CommonPageResource;
import com.mallinapps.commondto.dto.student.Grade;
import com.mallinapps.commondto.dto.student.GradeList;
import com.mallinapps.commondto.dto.student.Student;
import com.mallinapps.commondto.dto.student.StudentList;
import com.mallinapps.designdomain.common.PageRequest;
import com.mallinapps.designdomain.domain.student.GradeEntity;
import com.mallinapps.designdomain.domain.student.StudentEntity;
import liquibase.repackaged.org.apache.commons.collections4.CollectionUtils;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        builder = @Builder(disableBuilder = true))
public interface StudentMapper {

    default StudentList toStudentList(List<StudentEntity> studentEntities, PageRequest pageRequest) {
        return new StudentList(studentEntities.stream()
                                     .map(this::toStudent)
                                     .skip(pageRequest.getNumberOfSkippedElements())
                                     .limit(pageRequest.isFullPageRequest() ? CollectionUtils.size(studentEntities) : pageRequest.getSize())
                                     .toList(),
                             CommonPageResource.builder()
                                     .page(pageRequest.getPage())
                                     .size(pageRequest.getSize())
                                     .totalElements(CollectionUtils.size(studentEntities))
                                     .build());
    }

    Student toStudent(StudentEntity entity);

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    StudentEntity toStudentEntity(Student student);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    StudentEntity updateStudentEntity(Student student, @MappingTarget StudentEntity entity);

    default GradeList toGradeList(List<GradeEntity> gradeEntities, PageRequest pageRequest) {
        return new GradeList(gradeEntities.stream()
                                        .map(this::toGrade)
                                        .skip(pageRequest.getNumberOfSkippedElements())
                                        .limit(pageRequest.isFullPageRequest() ? CollectionUtils.size(gradeEntities) : pageRequest.getSize())
                                        .toList(),
                                CommonPageResource.builder()
                                        .page(pageRequest.getPage())
                                        .size(pageRequest.getSize())
                                        .totalElements(CollectionUtils.size(gradeEntities))
                                        .build());
    }
    
    Grade toGrade(GradeEntity entity);

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    GradeEntity toGradeEntity(Grade grade);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    GradeEntity updateGradeEntity(Grade dto, @MappingTarget GradeEntity entity);
}
