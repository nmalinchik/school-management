package com.mallinapps.designdomain.service;

import java.util.UUID;

import com.mallinapps.commondto.dto.student.Student;
import com.mallinapps.commondto.dto.student.StudentList;
import com.mallinapps.designdomain.common.PageRequest;
import com.mallinapps.designdomain.domain.student.StudentEntity;
import com.mallinapps.designdomain.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService extends CrudService<Student, StudentEntity> {

    private final StudentMapper mapper;

    @Transactional(readOnly = true)
    public StudentList getList(Integer page, Integer size) {
        return mapper.toStudentList(repository.findAll(), new PageRequest(page, size));
    }

    @Transactional(readOnly = true)
    public Student findById(final UUID id) {
        return mapper.toStudent(findEntityById(id));
    }

    @Transactional
    public Student create(final Student student) {
        checkNotNullFields(student.grade().id(), "grade");
        final var studentEntity = mapper.toStudentEntity(student);
        var saved = repository.save(studentEntity);
        return mapper.toStudent(saved);
    }

    @Transactional
    public Student update(final UUID id, final Student student) {
        checkNotNullFields(student.grade().id(), "grade");
        final var entity = mapper.updateStudentEntity(student, findEntityById(id));
        var saved = repository.save(entity);
        return mapper.toStudent(saved);
    }

}
