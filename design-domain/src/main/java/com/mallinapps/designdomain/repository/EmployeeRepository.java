package com.mallinapps.designdomain.repository;

import java.util.List;
import java.util.UUID;

import com.mallinapps.designdomain.domain.employee.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends GenericRepository<EmployeeEntity> {

    @Override
    @Query(value = "SELECT e from EmployeeEntity e " +
            "left join fetch e.position " +
            "left join fetch e.extraPosition")
    List<EmployeeEntity> findAll();

    @Query(value = "SELECT e from EmployeeEntity e " +
            "where e.position.id=:positionId " +
            "or e.extraPosition.id=:positionId")
    List<EmployeeEntity> findByPositions(UUID positionId);

}
