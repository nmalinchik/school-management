package com.mallinapps.commondto.dto.student;

import java.time.LocalDate;
import java.util.UUID;

public record StudentShort(UUID id,
                           String firstName,
                           String lastName,
                           String middleName,
                           LocalDate dateOfBirth,
                           UUID gradeId) {}
