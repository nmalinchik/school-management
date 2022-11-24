package com.mallinapps.designdomain.service;

import java.util.UUID;

import com.mallinapps.commondto.dto.student.Student;
import com.mallinapps.commondto.dto.student.StudentList;
import com.mallinapps.designdomain.common.PageRequest;
import com.mallinapps.designdomain.domain.student.StudentEntity;
import com.mallinapps.designdomain.exception.EmptyNecessaryFieldException;
import com.mallinapps.designdomain.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService extends CrudService<StudentList, Student, StudentEntity> {

    private final StudentMapper mapper;

    public StudentList getList(Integer page, Integer size) {
        log.info("get student list for selected page");
        return mapper.toStudentList(repository.findAll(), new PageRequest(page, size));
    }

    public Student findById(final UUID id) {
        log.info("find student by id {}", id);
        return mapper.toStudent(findEntityById(id));
    }

    public Student create(final Student student) {
        log.info("create student from dto: {}", student);
        if (student.grade().id() == null){
            throw new EmptyNecessaryFieldException("Empty id field in grade");
        }
        final var studentEntity = mapper.toStudentEntity(student);
        var saved = repository.save(studentEntity);
        return mapper.toStudent(saved);
    }

    public Student update(final UUID id, final Student student) {
        log.info("update student with id {} with dto: {}", id, student);
        if (student.grade().id() == null){
            throw new EmptyNecessaryFieldException("Empty id field in grade");
        }
        final var entity = mapper.updateStudentEntity(student, findEntityById(id));
        var saved = repository.save(entity);
        return mapper.toStudent(saved);
    }

}
