package com.mallinapps.designdomain.controller;

import java.util.UUID;

import com.mallinapps.commondto.dto.lesson.Lesson;
import com.mallinapps.commondto.dto.lesson.LessonList;
import com.mallinapps.designdomain.controller.api.CrudApi;
import com.mallinapps.designdomain.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/lesson")
public class LessonController implements CrudApi<LessonList, Lesson> {

    private final LessonService service;

    @Override
    public ResponseEntity<LessonList> getList(final Integer page, final Integer size) {
        return ResponseEntity.ok().body(service.getList(page, size));
    }

    @Override
    public ResponseEntity<Lesson> findById(final UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @Override
    public ResponseEntity<Lesson> create(final Lesson lesson) {
        return ResponseEntity.ok().body(service.create(lesson));
    }

    @Override
    public ResponseEntity<Lesson> update(final UUID id, final Lesson lesson) {
        return ResponseEntity.ok().body(service.update(id, lesson));
    }

    @Override
    public void delete(final UUID id) {
        service.delete(id);
    }
}
