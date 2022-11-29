package com.mallinapps.commondto.dto.academicperformance;

import java.time.LocalDate;
import java.util.UUID;

public record MarkShort(UUID id,
                        Integer mark,
                        LocalDate dateWhenSet,
                        UUID lessonId,
                        UUID studentId,
                        UUID teacherId) {}
