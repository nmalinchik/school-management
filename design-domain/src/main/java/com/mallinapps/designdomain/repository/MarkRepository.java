package com.mallinapps.designdomain.repository;

import java.util.List;

import com.mallinapps.designdomain.domain.academicperformance.MarkEntity;
import org.springframework.data.jpa.repository.Query;

public interface MarkRepository extends GenericRepository<MarkEntity> {

    @Override
    @Query(value = "SELECT m from MarkEntity m " +
            "left join fetch m.lesson " +
            "left join fetch m.student " +
            "left join fetch m.teacher")
    List<MarkEntity> findAll();

}
