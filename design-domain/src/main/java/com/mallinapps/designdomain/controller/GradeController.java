package com.mallinapps.designdomain.controller;

import java.util.UUID;

import com.mallinapps.commondto.dto.student.Grade;
import com.mallinapps.commondto.dto.student.GradeList;
import com.mallinapps.designdomain.controller.api.CrudApi;
import com.mallinapps.designdomain.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/grade")
public class GradeController implements CrudApi<GradeList, Grade> {

    private final GradeService service;

    @Override
    public GradeList getList(final Integer page, final Integer size) {
        return service.getList(page, size);
    }

    @Override
    public Grade findById(final UUID id) {
        return service.findById(id);
    }

    @Override
    public Grade create(final Grade position) {
        return service.create(position);
    }

    @Override
    public Grade update(final UUID id, final Grade position) {
        return service.update(id, position);
    }

    @Override
    public void delete(final UUID id) {
        service.delete(id);
    }
}
