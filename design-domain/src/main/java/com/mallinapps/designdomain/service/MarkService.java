package com.mallinapps.designdomain.service;

import java.util.UUID;

import com.mallinapps.commondto.dto.academicperformance.Mark;
import com.mallinapps.commondto.dto.academicperformance.MarkList;
import com.mallinapps.commondto.dto.academicperformance.MarkShort;
import com.mallinapps.designdomain.common.PageRequest;
import com.mallinapps.designdomain.domain.academicperformance.MarkEntity;
import com.mallinapps.designdomain.domain.employee.EmployeeEntity;
import com.mallinapps.designdomain.domain.lesson.LessonEntity;
import com.mallinapps.designdomain.domain.student.StudentEntity;
import com.mallinapps.designdomain.mapper.MarkMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javatuples.Triplet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class MarkService extends CrudService<Mark, MarkEntity> {

    private final MarkMapper mapper;
    private final LessonService lessonService;
    private final StudentService studentService;
    private final EmployeeService employeeService;

    @Transactional(readOnly = true)
    public MarkList getList(Integer page, Integer size) {
        return mapper.toMarkList(repository.findAll(), new PageRequest(page, size));
    }

    @Transactional(readOnly = true)
    public Mark findById(final UUID id) {
        return mapper.toMark(findEntityById(id));
    }

    @Transactional
    public Mark create(final MarkShort mark) {
        var triplet = getEntities(mark);

        final var markEntity = mapper.toMarkEntity(mark, triplet.getValue0(), triplet.getValue1(), triplet.getValue2());
        return mapper.toMark(repository.save(markEntity));
    }

    @Transactional
    public Mark update(final UUID id, final MarkShort mark) {
        var triplet = getEntities(mark);

        final var entity = mapper.updateMarkEntity(mark, findEntityById(id), triplet.getValue0(), triplet.getValue1(), triplet.getValue2());
        return mapper.toMark(repository.save(entity));
    }

    private Triplet<LessonEntity, StudentEntity, EmployeeEntity> getEntities(MarkShort mark) {
        checkNotNullFields(mark.lessonId(), "lesson");
        checkNotNullFields(mark.studentId(), "student");
        checkNotNullFields(mark.teacherId(), "teacher");
        return Triplet.with(lessonService.findEntityById(mark.lessonId()), studentService.findEntityById(mark.studentId()), employeeService.findEntityById(mark.teacherId()));
    }
}
