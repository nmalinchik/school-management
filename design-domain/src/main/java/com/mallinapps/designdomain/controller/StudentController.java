package com.mallinapps.designdomain.controller;

import java.util.UUID;

import com.mallinapps.commondto.dto.student.Student;
import com.mallinapps.commondto.dto.student.StudentList;
import com.mallinapps.designdomain.controller.api.CrudApi;
import com.mallinapps.designdomain.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/student")
public class StudentController implements CrudApi<StudentList, Student> {

    private final StudentService service;

    @Override
    public StudentList getList(final Integer page, final Integer size) {
        return service.getList(page, size);
    }

    @Override
    public Student findById(final UUID id) {
        return service.findById(id);
    }

    @Override
    public Student create(final Student position) {
        return service.create(position);
    }

    @Override
    public Student update(final UUID id, final Student position) {
        return service.update(id, position);
    }

    @Override
    public void delete(final UUID id) {
        service.delete(id);
    }
}
