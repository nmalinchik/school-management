package com.mallinapps.designdomain.service;

import java.util.UUID;

import com.mallinapps.commondto.dto.lesson.Lesson;
import com.mallinapps.commondto.dto.lesson.LessonList;
import com.mallinapps.designdomain.common.PageRequest;
import com.mallinapps.designdomain.domain.lesson.LessonEntity;
import com.mallinapps.designdomain.mapper.LessonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LessonService extends CrudService<Lesson, LessonEntity> {

    private final LessonMapper mapper;

    @Transactional(readOnly = true)
    public LessonList getList(Integer page, Integer size) {
        return mapper.toLessonList(repository.findAll(), new PageRequest(page, size));
    }

    @Transactional(readOnly = true)
    public Lesson findById(final UUID id) {
        return mapper.toLesson(findEntityById(id));
    }

    @Transactional
    public Lesson create(final Lesson lesson) {
        final var lessonEntity = mapper.toLessonEntity(lesson);
        var saved = repository.save(lessonEntity);
        return mapper.toLesson(saved);
    }

    @Transactional
    public Lesson update(final UUID id, final Lesson lesson) {
        final var entity = mapper.updateLessonEntity(lesson, findEntityById(id));
        var saved = repository.save(entity);
        return mapper.toLesson(saved);
    }

}
