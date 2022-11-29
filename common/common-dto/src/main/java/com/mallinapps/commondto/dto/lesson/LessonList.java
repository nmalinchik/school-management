package com.mallinapps.commondto.dto.lesson;

import java.util.List;

import com.mallinapps.commondto.dto.common.CommonPageResource;

public record LessonList(List<Lesson> lessons, CommonPageResource page) {}
