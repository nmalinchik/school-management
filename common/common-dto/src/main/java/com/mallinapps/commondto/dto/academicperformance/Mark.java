package com.mallinapps.commondto.dto.academicperformance;

import java.time.LocalDate;
import java.util.UUID;

import com.mallinapps.commondto.dto.employee.Employee;
import com.mallinapps.commondto.dto.lesson.Lesson;
import com.mallinapps.commondto.dto.student.Student;

public record Mark(UUID id,
                   Integer mark,
                   LocalDate dateWhenSet,
                   Lesson lesson,
                   Student student,
                   Employee teacher) {}
