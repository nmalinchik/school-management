package com.mallinapps.designdomain.controller;

import java.util.UUID;

import com.mallinapps.commondto.dto.student.Grade;
import com.mallinapps.commondto.dto.student.GradeList;
import com.mallinapps.designdomain.controller.api.CrudApi;
import com.mallinapps.designdomain.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/grade")
public class GradeController implements CrudApi<GradeList, Grade> {

    private final GradeService service;

    @Override
    public ResponseEntity<GradeList> getList(final Integer page, final Integer size) {
        return ResponseEntity.ok().body(service.getList(page, size));
    }

    @Override
    public ResponseEntity<Grade> findById(final UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @Override
    public ResponseEntity<Grade> create(final Grade grade) {
        return ResponseEntity.ok().body(service.create(grade));
    }

    @Override
    public ResponseEntity<Grade> update(final UUID id, final Grade grade) {
        return ResponseEntity.ok().body(service.update(id, grade));
    }

    @Override
    public void delete(final UUID id) {
        service.delete(id);
    }
}
