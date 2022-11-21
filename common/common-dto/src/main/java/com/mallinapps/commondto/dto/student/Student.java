package com.mallinapps.commondto.dto.student;

import java.time.LocalDate;
import java.util.UUID;

public record Student(UUID id,
                      String firstName,
                      String lastName,
                      String middleName,
                      LocalDate dateOfBirth,
                      Grade grade) {}
