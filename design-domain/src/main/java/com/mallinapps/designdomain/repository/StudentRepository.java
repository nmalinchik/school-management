package com.mallinapps.designdomain.repository;

import java.util.List;
import java.util.UUID;

import com.mallinapps.designdomain.domain.student.StudentEntity;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends GenericRepository<StudentEntity> {

    @Query(value = "SELECT s FROM StudentEntity s " +
                   "WHERE s.grade.id=:gradeId")
    List<StudentEntity> findByGradeId(UUID gradeId);

}
