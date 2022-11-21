package com.mallinapps.commondto.dto.lesson;

import java.util.UUID;

public record Lesson(UUID id,
                     String title,
                     String description) {}
