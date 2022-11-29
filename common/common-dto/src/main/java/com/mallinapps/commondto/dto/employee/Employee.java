package com.mallinapps.commondto.dto.employee;

import java.time.LocalDate;
import java.util.UUID;

public record Employee(UUID id,
                       String firstName,
                       String lastName,
                       String middleName,
                       LocalDate dateOfBirth,
                       Position position,
                       Position extraPosition) {}
