package com.mallinapps.commondto.mapstruct;

import com.mallinapps.commondto.dto.student.Grade;
import com.mallinapps.commondto.dto.student.Student;
import com.mallinapps.designdomain.domain.student.GradeEntity;
import com.mallinapps.designdomain.domain.student.StudentEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        builder = @Builder(disableBuilder = true))
public interface StudentMapper {

    Student toStudent(StudentEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    @Mapping(target = "version", ignore = true)
    StudentEntity toStudentEntity(Student student);

    Grade toGrade(GradeEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "lastUpdatedBy", ignore = true)
    @Mapping(target = "lastUpdateDate", ignore = true)
    GradeEntity toGradeEntity(Grade grade);
}
