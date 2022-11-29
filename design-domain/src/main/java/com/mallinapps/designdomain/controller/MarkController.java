package com.mallinapps.designdomain.controller;

import java.util.UUID;

import com.mallinapps.commondto.dto.academicperformance.Mark;
import com.mallinapps.commondto.dto.academicperformance.MarkList;
import com.mallinapps.commondto.dto.academicperformance.MarkShort;
import com.mallinapps.designdomain.controller.api.MarkApi;
import com.mallinapps.designdomain.service.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/mark")
public class MarkController implements MarkApi {

    private final MarkService service;

    @Override
    public ResponseEntity<MarkList> getList(final Integer page, final Integer size) {
        return ResponseEntity.ok().body(service.getList(page, size));
    }

    @Override
    public ResponseEntity<Mark> findById(final UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @Override
    public ResponseEntity<Mark> create(final MarkShort mark) {
        return ResponseEntity.ok().body(service.create(mark));
    }

    @Override
    public ResponseEntity<Mark> update(final UUID id, final MarkShort mark) {
        return ResponseEntity.ok().body(service.update(id, mark));
    }

    @Override
    public void delete(final UUID id) {
        service.delete(id);
    }
}
