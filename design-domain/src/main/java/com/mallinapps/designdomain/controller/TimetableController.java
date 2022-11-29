package com.mallinapps.designdomain.controller;

import java.util.UUID;

import com.mallinapps.commondto.dto.timetable.TimetableDay;
import com.mallinapps.commondto.dto.timetable.TimetableDayShort;
import com.mallinapps.commondto.dto.timetable.TimetableLesson;
import com.mallinapps.commondto.dto.timetable.TimetableLessonShort;
import com.mallinapps.commondto.dto.timetable.TimetableWeek;
import com.mallinapps.commondto.dto.timetable.TimetableWeekShort;
import com.mallinapps.designdomain.controller.api.TimetableApi;
import com.mallinapps.designdomain.service.TimetableDayService;
import com.mallinapps.designdomain.service.TimetableLessonService;
import com.mallinapps.designdomain.service.TimetableWeekService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/timetable")
public class TimetableController implements TimetableApi {

    private final TimetableWeekService weekService;
    private final TimetableDayService dayService;
    private final TimetableLessonService lessonService;

    @Override
    public ResponseEntity<Boolean> copyWeek(final UUID fromId, final Integer weekOfYear) {
        return ResponseEntity.ok().body(weekService.copyWeek(fromId, weekOfYear));
    }

    @Override
    public ResponseEntity<TimetableWeek> findWeekById(final UUID id) {
        return ResponseEntity.ok().body(weekService.findById(id));
    }

    @Override
    public ResponseEntity<TimetableWeek> createWeek(final TimetableWeekShort dto) {
        return ResponseEntity.ok().body(weekService.create(dto));
    }

    @Override
    public ResponseEntity<TimetableWeek> updateWeek(final UUID id, final TimetableWeekShort dto) {
        return ResponseEntity.ok().body(weekService.update(id, dto));
    }

    @Override
    public void deleteWeek(final UUID id) {
        weekService.delete(id);
    }

    @Override
    public ResponseEntity<TimetableDay> findDayById(final UUID id) {
        return ResponseEntity.ok().body(dayService.findById(id));
    }

    @Override
    public ResponseEntity<TimetableDay> createDay(final TimetableDayShort dto) {
        return ResponseEntity.ok().body(dayService.create(dto));
    }

    @Override
    public ResponseEntity<TimetableDay> updateDay(final UUID id, final TimetableDayShort dto) {
        return ResponseEntity.ok().body(dayService.update(id, dto));
    }

    @Override
    public void deleteDay(final UUID id) {
        dayService.delete(id);
    }

    @Override
    public ResponseEntity<TimetableLesson> findLessonById(final UUID id) {
        return ResponseEntity.ok().body(lessonService.findById(id));
    }

    @Override
    public ResponseEntity<TimetableLesson> createLesson(final TimetableLessonShort dto) {
        return ResponseEntity.ok().body(lessonService.create(dto));
    }

    @Override
    public ResponseEntity<TimetableLesson> updateLesson(final UUID id, final TimetableLessonShort dto) {
        return ResponseEntity.ok().body(lessonService.update(id, dto));
    }

    @Override
    public void deleteLesson(final UUID id) {
        lessonService.delete(id);
    }
}
