package com.mallinapps.commondto.dto.employee;

import java.time.LocalDate;
import java.util.UUID;

public record EmployeeShort(UUID id,
                            String firstName,
                            String lastName,
                            String middleName,
                            LocalDate dateOfBirth,
                            UUID positionId,
                            UUID extraPositionId) {}
