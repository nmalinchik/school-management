package com.mallinapps.commondto.dto.student;

import java.util.UUID;

import com.mallinapps.designdomain.domain.enums.Grades;

public record Grade(UUID id,
                    Grades grade,
                    String letter) {}
