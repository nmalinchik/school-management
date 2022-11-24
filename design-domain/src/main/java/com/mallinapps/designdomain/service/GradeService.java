package com.mallinapps.designdomain.service;

import java.util.UUID;

import com.mallinapps.commondto.dto.student.Grade;
import com.mallinapps.commondto.dto.student.GradeList;
import com.mallinapps.designdomain.common.PageRequest;
import com.mallinapps.designdomain.domain.student.GradeEntity;
import com.mallinapps.designdomain.mapper.EmployeeMapper;
import com.mallinapps.designdomain.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GradeService extends CrudService<GradeList, Grade, GradeEntity> {

    private final StudentMapper mapper;

    public GradeList getList(Integer page, Integer size) {
        log.info("get grade list for selected page");
        return mapper.toGradeList(repository.findAll(), new PageRequest(page, size));
    }

    public Grade findById(final UUID id) {
        log.info("find grade by id {}", id);
        return mapper.toGrade(findEntityById(id));
    }

    public Grade create(final Grade grade) {
        log.info("create grade from dto: {}", grade);
        final var gradeEntity = mapper.toGradeEntity(grade);
        var saved = repository.save(gradeEntity);
        return mapper.toGrade(saved);
    }

    public Grade update(final UUID id, final Grade grade) {
        log.info("update grade with id {} with dto: {}", id, grade);
        final var entity = mapper.updateGradeEntity(grade, findEntityById(id));
        var saved = repository.save(entity);
        return mapper.toGrade(saved);
    }

}
