package com.mallinapps.designdomain.controller.api;

import java.util.UUID;

import com.mallinapps.commondto.dto.timetable.TimetableDay;
import com.mallinapps.commondto.dto.timetable.TimetableDayShort;
import com.mallinapps.commondto.dto.timetable.TimetableLesson;
import com.mallinapps.commondto.dto.timetable.TimetableLessonShort;
import com.mallinapps.commondto.dto.timetable.TimetableWeek;
import com.mallinapps.commondto.dto.timetable.TimetableWeekShort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface TimetableApi {

    @PostMapping("/week/copy/{fromId}")
    ResponseEntity<Boolean> copyWeek(@PathVariable UUID fromId, @RequestParam Integer weekOfYear);

    @GetMapping("/week/{id}")
    ResponseEntity<TimetableWeek> findWeekById(@PathVariable UUID id);

    @PostMapping("/week")
    ResponseEntity<TimetableWeek> createWeek(@RequestBody TimetableWeekShort dto);

    @PutMapping("/week/{id}")
    ResponseEntity<TimetableWeek> updateWeek(@PathVariable UUID id, @RequestBody TimetableWeekShort dto);

    @DeleteMapping("/week/{id}")
    void deleteWeek(@PathVariable UUID id);


    @GetMapping("/day/{id}")
    ResponseEntity<TimetableDay> findDayById(@PathVariable UUID id);

    @PostMapping("/day")
    ResponseEntity<TimetableDay> createDay(@RequestBody TimetableDayShort dto);

    @PutMapping("/day/{id}")
    ResponseEntity<TimetableDay> updateDay(@PathVariable UUID id, @RequestBody TimetableDayShort dto);

    @DeleteMapping("/day/{id}")
    void deleteDay(@PathVariable UUID id);


    @GetMapping("/lesson/{id}")
    ResponseEntity<TimetableLesson> findLessonById(@PathVariable UUID id);

    @PostMapping("/lesson")
    ResponseEntity<TimetableLesson> createLesson(@RequestBody TimetableLessonShort dto);

    @PutMapping("/lesson/{id}")
    ResponseEntity<TimetableLesson> updateLesson(@PathVariable UUID id, @RequestBody TimetableLessonShort dto);

    @DeleteMapping("/lesson/{id}")
    void deleteLesson(@PathVariable UUID id);

}
