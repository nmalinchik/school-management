package com.mallinapps.designdomain.controller;

import java.util.UUID;

import com.mallinapps.commondto.dto.employee.Position;
import com.mallinapps.commondto.dto.employee.PositionList;
import com.mallinapps.designdomain.controller.api.CrudApi;
import com.mallinapps.designdomain.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/position")
public class PositionController implements CrudApi<PositionList, Position> {

    private final PositionService service;

    @Override
    public PositionList getList(final Integer page, final Integer size) {
        return service.getList(page, size);
    }

    @Override
    public Position findById(final UUID id) {
        return service.findById(id);
    }

    @Override
    public Position create(final Position position) {
        return service.create(position);
    }

    @Override
    public Position update(final UUID id, final Position position) {
        return service.update(id, position);
    }

    @Override
    public void delete(final UUID id) {
        service.delete(id);
    }
}
