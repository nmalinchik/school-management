package com.mallinapps.designdomain.service;

import java.util.UUID;
import java.util.stream.Collectors;

import com.mallinapps.commondto.dto.student.Grade;
import com.mallinapps.commondto.dto.student.GradeList;
import com.mallinapps.designdomain.common.PageRequest;
import com.mallinapps.designdomain.domain.student.GradeEntity;
import com.mallinapps.designdomain.domain.student.StudentEntity;
import com.mallinapps.designdomain.exception.CantBeDeletedException;
import com.mallinapps.designdomain.mapper.StudentMapper;
import com.mallinapps.designdomain.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GradeService extends CrudService<Grade, GradeEntity> {

    private final StudentMapper mapper;
    private final StudentRepository studentRepository;
    private final TimetableWeekService weekService;

    @Transactional(readOnly = true)
    public GradeList getList(Integer page, Integer size) {
        return mapper.toGradeList(repository.findAll(), new PageRequest(page, size));
    }

    @Transactional(readOnly = true)
    public Grade findById(final UUID id) {
        return mapper.toGrade(findEntityById(id));
    }

    @Transactional
    public Grade create(final Grade grade) {
        final var gradeEntity = mapper.toGradeEntity(grade);
        var saved = repository.save(gradeEntity);
        return mapper.toGrade(saved);
    }

    @Transactional
    public Grade update(final UUID id, final Grade grade) {
        final var entity = mapper.updateGradeEntity(grade, findEntityById(id));
        var saved = repository.save(entity);
        return mapper.toGrade(saved);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        var students = studentRepository.findByGradeId(id);
        if (students.isEmpty()) {
            weekService.deleteSchedulesForGrade(id);
            repository.deleteById(id);
        } else {
            var employeeFIOs = students.stream()
                    .map(this::getFio)
                    .collect(Collectors.joining(", "));
            throw new CantBeDeletedException("В данном классе в данный момент числится(ятся): " + employeeFIOs);
        }
    }

    private String getFio(StudentEntity student) {
        return student.getLastName() + " " + student.getFirstName()
                .charAt(0) + "." + student.getMiddleName()
                .charAt(0) + ".";
    }

}
