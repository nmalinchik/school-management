package com.mallinapps.designdomain.controller;

import java.util.UUID;

import com.mallinapps.commondto.dto.student.Student;
import com.mallinapps.commondto.dto.student.StudentList;
import com.mallinapps.designdomain.controller.api.CrudApi;
import com.mallinapps.designdomain.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/student")
public class StudentController implements CrudApi<StudentList, Student> {

    private final StudentService service;

    @Override
    public ResponseEntity<StudentList> getList(final Integer page, final Integer size) {
        return ResponseEntity.ok().body(service.getList(page, size));
    }

    @Override
    public ResponseEntity<Student> findById(final UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @Override
    public ResponseEntity<Student> create(final Student student) {
        return ResponseEntity.ok().body(service.create(student));
    }

    @Override
    public ResponseEntity<Student> update(final UUID id, final Student student) {
        return ResponseEntity.ok().body(service.update(id, student));
    }

    @Override
    public void delete(final UUID id) {
        service.delete(id);
    }
}
